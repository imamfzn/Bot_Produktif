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
		
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	

}
