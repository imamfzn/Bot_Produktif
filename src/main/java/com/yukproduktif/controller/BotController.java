
package com.yukproduktif.controller;
import com.yukproduktif.model.*;
import com.yukproduktif.service.*;
import com.yukproduktif.repository.*;

import com.google.gson.Gson;
import com.linecorp.bot.client.LineSignatureValidator;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/linebot")
public class BotController
{
    @Autowired
    @Qualifier("com.linecorp.channel_secret")
    String lChannelSecret;
    
    @Autowired
    @Qualifier("com.linecorp.channel_access_token")
    String lChannelAccessToken;
    
    @Autowired
    ReminderRepository reminderRepo;
    
    LineBotService botService = new LineBotService();
    AdzanService adzanService = new AdzanService();
    
    MainViewBot mainView = new MainViewBot();
    PrayerTimesView adzanView = new PrayerTimesView();
    ReminderWajibView reminderWajibView = new ReminderWajibView();

    @RequestMapping(value="/callback", method=RequestMethod.POST)
    public ResponseEntity<String> callback(
        @RequestHeader("X-Line-Signature") String aXLineSignature,
        @RequestBody String aPayload)
    {
        final String text=String.format("The Signature is: %s",
            (aXLineSignature!=null && aXLineSignature.length() > 0) ? aXLineSignature : "N/A");
        System.out.println(text);
        final boolean valid=new LineSignatureValidator(lChannelSecret.getBytes()).validateSignature(aPayload.getBytes(), aXLineSignature);
        System.out.println("The signature is: " + (valid ? "valid" : "tidak valid"));
        if(aPayload!=null && aPayload.length() > 0)
        {
            System.out.println("Payload: " + aPayload);
        }
        
        //Mengubah data request body menjadi bentuk object
        Gson gson = new Gson();
        Payload payload = gson.fromJson(aPayload, Payload.class);
        
        //Set channel access token to bot service
        //Issue : harusnya kalau bisa gak perlu di set setiap waktu
        //To-do : buat set channel accest oken on the fly , autowired ?
        botService.setChannelAccessToken(lChannelAccessToken);

        String msgText = " ";
        String idTarget = " ";
        String eventType = payload.events[0].type;

        if (eventType.equals("join")){
            if (payload.events[0].source.type.equals("group")){
            	botService.replyToUser(payload.events[0].replyToken, "Hello Group");
            }
            
            else if (payload.events[0].source.type.equals("room")){
            	botService.replyToUser(payload.events[0].replyToken, "Hello Room");
            }
        } 
        
        else if (eventType.equals("message")){
            if (payload.events[0].source.type.equals("group")){
                idTarget = payload.events[0].source.groupId;
            } 
            
            else if (payload.events[0].source.type.equals("room")){
                idTarget = payload.events[0].source.roomId;
            } 
            
            else if (payload.events[0].source.type.equals("user")){
                idTarget = payload.events[0].source.userId;
            }
            
            if (payload.events[0].message.type.equals("text")){
                //msgText = "--DEBUG EDISI RAMADHAN--";
            	msgText = payload.events[0].message.text.toLowerCase();
            	System.out.println(msgText);
            	if (msgText.equals("bot adzan")){
            		String res = adzanService.getPrayerTimes().toString();
            		botService.pushMessage(idTarget, res);
            	}
            	else if (msgText.equals("test wellcome")){
            		botService.sendTemplateMessage(idTarget, mainView.getViewMessage());
            	}
            	else if (msgText.equals("test adzan")){
            		botService.sendTemplateMessage(idTarget, adzanView.getViewMessage());
            	}
            	else if (msgText.equals("test reminder")){
            		botService.sendTemplateMessage(idTarget, reminderWajibView.getViewMessage());
            	}
            	else if (msgText.contains("reminder")){
            		reminderHandler(idTarget, msgText);
            	}
            	
                
            }
        }
         
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    /**
     * @author Muhammad Imam Fauzan
     * Mengganti status reminder yang sudah ada atupun untuk user yang belum terdaftar pada data reminder.
     * @param userId 	: user id line follower, yang akan dituju
     * @param adzanName : nama waktu adzan
     * @param newStatus	: status baru yang akan di update pada data reminder
     */
    private void changeReminderStatus(String userId, String adzanName, boolean newStatus){
    	BotReminder userReminder = (BotReminder) reminderRepo.findByUserId(userId);
		String reminderRespon = "";
		//apabila user id sudah terdaftar / sudah pernah mengaktifkan reminder
		if (userReminder != null){
			if (userReminder.isActive(adzanName) != newStatus){
				userReminder.setReminder(adzanName, newStatus);
				try {
					reminderRepo.save(userReminder);
					reminderRespon = newStatus == true ? 
							"Reminder untuk adzan " + adzanName + " berhasil diaktifkan." :
							"Reminder untuk adzan " + adzanName + " berihasil dinon-aktifkan."; 
				} 
				catch (Exception ex){
					reminderRespon = newStatus == true ?
							"Gagal mengaktifkan reminder, silahkan coba lagi." :
							"Gagal menonaktifkan reminder, silahkan coba lagi.";
				}	
			}
			else {
				reminderRespon = newStatus == true ? 
						"Reminder untuk adzan " + adzanName + " sudah aktif." :
						"Reminder untuk adzan " + adzanName + " sudah tidak aktif.";
			}
		}
		
		//user id belum terfdaftar
		else {
			try {
				//register user
				BotReminder newUserReminder = new BotReminder(userId);
				newUserReminder.setReminder(adzanName, true);
				reminderRepo.save(newUserReminder);
				reminderRespon = "Reminder untuk adzan " + adzanName + " berhasil diaktifkan.";
			} 
			catch (Exception ex){
				reminderRespon = "Gagal mengaktifkan reminder, silahkan coba lagi.";
			}	
		}
		
		//send respon reminder to user..
		botService.pushMessage(userId, reminderRespon);
		
    }
    
    /**
     * @author Muhammad Imam Fauzan
     *  method untuk menanangani pengaktifan dan nonaktif reminder
     */
    private void reminderHandler(String userId, String reminderRequest){
    	String[] request = reminderRequest.split(" ");
    	String listRequest =  "shubuh dzuhur ashar magrib isya dhuha tahajud";
    	
    	if (request[0].equals("reminder")){
    		if (listRequest.contains(request[1])){
    			//Mengaktifkan reminder
    			if (request[2].equals("on") || request[2].equals("off")){
    				boolean newStatus = request[2].equals("on");
    				String adzanName = request[1];
    				changeReminderStatus(userId, adzanName, newStatus);
    			}
    		}
    	}
    }
    
    /**
     * @author Muhammad Imam Fauzan, Rahman Faruq Rajabyansyahr
     * Menerima data yang dikirim dari service reminder, untuk broadcast reminder ke semua line follower bot
     * @param data : request body dari reminder service, yang isinya bakal di handle, untuk broadcast ke line follower
     * @return HttpStatus
     */
    @RequestMapping(value="/reminder", method=RequestMethod.POST)
    public ResponseEntity<String> reminder(@RequestBody String data){
    	/* DEBUG */
        Gson gson = new Gson();
        DataReminder dataReminder = gson.fromJson(data, DataReminder.class);
    	String ID_TARGET = "Ccb45584fc566bd5270591a3d010ae4b0";
        String MESSAGE = "Saatnya adzan " + dataReminder.reminder.name;
        // System.out.println(dataReminder.reminder.name);
    	botService.setChannelAccessToken(lChannelAccessToken);
    	botService.pushMessage(ID_TARGET, MESSAGE);
    	
        // System.out.println("DEBUG");
        /* DEBUG */
    	/**
    	 * to-do :
    	 * Buat model untuk menampung request body dari sevice reminder (pake gson)
    	 * Handle setiap jenis reminder yang masuk dari service reminder
    	 * Query ke database, line follower yang mengaktifkan reminder
    	 * Kirim reminder ke line follower ..
    	 */
    	return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping(value="/testdb", method=RequestMethod.GET)
    public ResponseEntity<String> testdb(){
    	String USER_ID = "Ccb45584fc566bd5270591a3d010ae4b0";
    	
    	try {
    		reminderRepo.save(new BotReminder(USER_ID, true, true, false, true, false));
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	return new ResponseEntity<String>(HttpStatus.OK);
    }
        
    
    /**
     * @author Muhammad Imam Fauzan
     * Menghandle request message yang dikirim dari user line ke bot
     * @param message : request message yang dikirim dari user line
     */
    private void botAction(String message){
    	if (message.equals("jadwal shalat")){
    		//Kirim jadwal shalat
    		//jadwal shalat yang dikirim dalam bentuk caorousel dan text
    		//format carousel dikirimkan pertama lalu text
    		
    	}
    	else if (message.equals("reminder wajib")){
    		//Kirim carousel setting reminder wajib
    		//membutuhkan model carousel dengan 5 column
    		//setiap column menyatakan settingan untuk 1 waktu adzan
    	}
    	else if (message.equals("reminder sunnah")){
    		//Kirim carousel setting reminder sunnah
    		//membtuhkan model caorousel dengan 5 column
    		//setiap column menyatakan settingan untuk 1 waktu ibadah sunnah
    	}
    	else if (message.equals("test wellcome")){
    		
    	}
    }
    
    //To-Do
    //Kirim informasi adzan yang di request dari user
    //Panggil service adzan
    //Kirim data adzan yang udah diambil dari service adzan pake LineBotService
    private void sendAdzanInformation(){
    	
    }
    
    //To-Do
    //Kirim 5 masjid terdekat berdasarkan lokasi user
    //Panggil service masjid
    //kirim data masjid menggunakan carousel 5 kolom, kirim pake LineBotService
    private void sendNearestMosque(/*location */){
    	
    }
    
}
