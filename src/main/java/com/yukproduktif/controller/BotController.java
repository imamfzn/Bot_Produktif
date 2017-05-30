
package com.yukproduktif.controller;

import com.google.gson.Gson;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.client.LineSignatureValidator;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;

import com.yukproduktif.model.*;
import com.yukproduktif.service.*;

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
    
    LineBotService botService = new LineBotService();

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
                msgText = "--DEBUG EDISI RAMADHAN--";
                botService.pushMessage(idTarget, msgText);
            }
        }
         
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    /**
     * @author Muhammad Imam Fauzan
     * Menerima data yang dikirim dari service reminder, untuk broadcast reminder ke semua line follower bot
     * @param data : request body dari reminder service, yang isinya bakal di handle, untuk broadcast ke line follower
     * @return HttpStatus
     */
    @RequestMapping(value="/reminder", method=RequestMethod.POST)
    public ResponseEntity<String> reminder(@RequestBody String data){
    	/* DEBUG */
    	String MESSAGE = "POST SUKSES ...." + "\n" + data;
    	String ID_TARGET = "Ccb45584fc566bd5270591a3d010ae4b0";
    	botService.setChannelAccessToken(lChannelAccessToken);
    	botService.pushMessage(ID_TARGET, MESSAGE);
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
    
    /**
     * @author Muhammad Imam Fauzan
     * Menghandle request message yang dikirim dari user line ke bot
     * @param message : request message yang dikirim dari user line
     */
    private void botAction(String message){
    	switch (message) {
    		case "bot adzan" :
    			
    		break;
    		case "bot reminder" :
    			
    		break;
    		
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
