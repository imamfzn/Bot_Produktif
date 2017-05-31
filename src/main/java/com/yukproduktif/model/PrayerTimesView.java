package com.yukproduktif.model;
import com.linecorp.bot.model.message.*;
import com.linecorp.bot.model.message.template.*;
import com.linecorp.bot.model.action.*;

import java.util.Arrays;
import java.util.List;



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
	
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	
	public String getTextMessage(){
		return textMessage;
	}
}
