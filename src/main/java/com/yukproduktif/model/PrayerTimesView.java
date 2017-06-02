package com.yukproduktif.model;
import com.linecorp.bot.model.message.*;
import com.linecorp.bot.model.message.template.*;
import com.linecorp.bot.model.action.*;

import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author Muhammad Imam Fauzan
 * View untuk menampilkan jadwal adzan
 * View dalam bentuk Carousel 5 Kolom dan Text dengan format yang sudah ditentukan Assalam.
 */
public class PrayerTimesView {
	private final static String IMAGE_URL_SHUBUH = "https://i2.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/1.jpg?w=463&h=307&crop&ssl=1";
	private final static String IMAGE_URL_DZUHUR = "https://i0.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/2.jpg?w=229&h=152&crop&ssl=1";
	private final static String IMAGE_URL_ASHAR = "https://i2.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/3.jpg?w=229&h=151&crop&ssl=1";
	private final static String IMAGE_URL_MAGRIB = "https://i2.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/4.jpg?w=346&h=229&crop&ssl=1";
	private final static String IMAGE_URL_ISYA = "https://i0.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/5.jpg?w=346&h=229&crop&ssl=1";
	private final static String TITLE = "Jadwal Adzan";
	
	private String textMessage;
	//action dummy ...
	private List<Action> actions;
	private List<CarouselColumn> columns;
	private Template carousel;
	private TemplateMessage viewMessage;
	
	public PrayerTimesView(){
		//create view carousel message
		actions = Arrays.asList(new URIAction("Yuk Shalat! :)", "https://line.me/R/ti/p/%40LTA5871H")); //dumy button
		
		columns = Arrays.asList(
				new CarouselColumn(IMAGE_URL_SHUBUH,"Waktu Shubuh","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_DZUHUR,"Waktu Dzuhur","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_ASHAR,"Waktu Ashar","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_MAGRIB,"Waktu Magrib","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_ISYA,"Waktu Isya","04:30 am", actions)
		);
		
		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
		
		//create text message format..
		textMessage = "";
	}
	
	public PrayerTimesView(PrayerTimes jadwalAdzan){
		//create view carousel message
		actions = Arrays.asList(new URIAction("Yuk Shalat! :)", "https://line.me/R/ti/p/%40LTA5871H")); //dumy button
		
		columns = Arrays.asList(
				new CarouselColumn(IMAGE_URL_SHUBUH,"Waktu Shubuh","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_DZUHUR,"Waktu Dzuhur","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_ASHAR,"Waktu Ashar","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_MAGRIB,"Waktu Magrib","04:30 am", actions),
				new CarouselColumn(IMAGE_URL_ISYA,"Waktu Isya","04:30 am", actions)
		);
		
		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
		
		//create text message format..
		textMessage = "[ JADWAL SHALAT ]\nBismillah\uD83C\uDF43\n\n\uD83D\uDCC6 Rabu, 17 Mei 2017\n\uD83C\uDF3A 20 Sya'ban 1438H\n\uD83C\uDFE2Bandung dan sekitarnya\n\nShubuh  04:35 am\nDzuhur 11:51 am\nAshar 03:13 pm\nMaghrib 05:46 pm\nIsya 06:59 pm\n\n\"Dan yang menghalang-halangi infak mereka untuk diterima adalah karena mereka kafir (ingkar) kepada Allah dan Rasul-Nya dan mereka tidak melaksanakan sholat, melainkan dengan malas dan tidak (pula) menginfakkan (harta) mereka, melainkan dengan rasa enggan (terpaksa).\"\n\uD83C\uDF42QS. At-Taubah 9: Ayat 54\uD83C\uDF42\n\n#AssalamReminder\n#MadaniBersama\n#SatuDalamIslam";
	       
	}
	
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	
	public String getTextMessage(){
		return textMessage;
	}
}
