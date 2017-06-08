package com.yukproduktif.model.view;
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
public class MenuBotView {
	private final static String IMAGE_URL = "https://lh3.ggpht.com/Su-kBS_TEjK9ISAcAPNWMHL0OCNyiP56aeB5czxCqxgg3KrPfqL4qcRLJvwBjWummw=h310";
	private final static String TITLE = "Menu Bot";
	private final static String CONTENT = "Tekan tombol berikut untuk memerintahkan bot.";
	private final static String WELLCOME_MESSAGE = "Assalamu\'alaikum Wr. Wb.";
	
	private List<Action> actions;
	private Template buttonTemplate;
	private TemplateMessage viewMessage;
	
	public MenuBotView(){
		actions = Arrays.asList(
				new MessageAction("Jadwal Shalat", "jadwal shalat"),
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
