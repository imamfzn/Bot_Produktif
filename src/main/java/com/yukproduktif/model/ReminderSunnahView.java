package com.yukproduktif.model;

import java.util.Arrays;
import java.util.List;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.message.template.Template;

public class ReminderSunnahView {
	
	private final static String TITLE = "Setting Reminder Sunnah";
	private final static String IMAGE_URL_DHUHA = "https://i2.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/1.jpg?w=463&h=307&crop&ssl=1";
	private final static String IMAGE_URL_TAHAJUD = "https://i0.wp.com/dalamruangkeheningan.files.wordpress.com/2017/05/2.jpg?w=229&h=152&crop&ssl=1";
	
	private List<CarouselColumn> columns;
	private Template carousel;
	private TemplateMessage viewMessage;
	
	public ReminderSunnahView(){
		//create view carousel message				
		columns = Arrays.asList(
			new CarouselColumn(IMAGE_URL_DHUHA,"Reminder Dhuha","08:30 am", Arrays.asList(new MessageAction("Aktifkan", "reminder sunnah dhuha on"))),
			new CarouselColumn(IMAGE_URL_TAHAJUD,"Reminder Tahajud","02:30 am", Arrays.asList(new MessageAction("Aktifkan", "reminder sunnah tahajud on")))
		);
				
		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
				
	}
	
	/*
	public ReminderWajibView(ReminderWajib reminder){
		//create view carousel message				
		columns = Arrays.asList(
			new CarouselColumn(IMAGE_URL_SHUBUH,"Reminder Shubuh","04:30 am", Arrays.asList(new MessageAction(getActiveText(reminder.isShubuhActive()), getRequestText("shubuh", reminder.isShubuhActive())))),
			new CarouselColumn(IMAGE_URL_DZUHUR,"Dzuhur Dzuhur","04:30 am", Arrays.asList(new MessageAction(getActiveText(reminder.isDzuhurActive()), getRequestText("dzuhur", reminder.isDzuhurActive())))),
			new CarouselColumn(IMAGE_URL_ASHAR,"Reminder Ashar","04:30 am",  Arrays.asList(new MessageAction(getActiveText(reminder.isAsharActive()), getRequestText("ashar", reminder.isAsharActive())))),
			new CarouselColumn(IMAGE_URL_MAGRIB,"Reminder Magrib","04:30 am", Arrays.asList(new MessageAction(getActiveText(reminder.isMagribActive()), getRequestText("magrib", reminder.isMagribActive())))),
			new CarouselColumn(IMAGE_URL_ISYA,"Reminder Isya","04:30 am", Arrays.asList(new MessageAction(getActiveText(reminder.isIsyaActive()), getRequestText("isya", reminder.isIsyaActive()))))
		);
				
		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
				
	}*/
	
	private String getActiveText(boolean active){
		return active ? "Non-Aktifkan" : "Aktifkan";
	}
	
	private String getRequestText(String adzanName, boolean active){
		return "reminder " + adzanName + (active ? " off" : " on");
	}
	
	
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	

}