package com.yukproduktif.model;
import com.linecorp.bot.model.message.*;
import com.linecorp.bot.model.message.template.*;
import com.linecorp.bot.model.action.*;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Muhammad Imam Fauzan
 * Model view untuk menampilkan perintah apa saja yang dapat dilakukan oleh bot
 *
 */
public class MenuViewBot {
	private final static String IMAGE_URL = "http://www.telegraph.co.uk/content/dam/Travel/galleries/travel/artsandculture/The-worlds-most-beautiful-mosques/blue-mosque-istanb_3379057a-xlarge.jpg";
	private final static String TITLE = "Menu Bot";
	private final static String CONTENT = "Tekan tombol berikut untuk memerintahkan bot.";
	private final static String WELLCOME_MESSAGE = "Assalamu\'alaikum Wr. Wb.";
	
	private List<Action> actions;
	private Template buttonTemplate;
	private TemplateMessage viewMessage;
	
	public MenuViewBot(){
		actions = Arrays.asList(
				new MessageAction("Jadwal Adzan", "jadwal adzan"),
				new MessageAction("Reminder Wajib", "reminder wajib"),
				new MessageAction("Reminder Sunnah", "reminder sunnah"),
				new MessageAction("Masjid Terdekat", "masjid terdekat")
		);
		
		buttonTemplate = new ButtonsTemplate(IMAGE_URL, TITLE, CONTENT, actions);
		viewMessage = new TemplateMessage(WELLCOME_MESSAGE, buttonTemplate);
	}

	public TemplateMessage getViewMessage() {
		return viewMessage;
	}
	
}
