package com.yukproduktif.model;
import com.linecorp.bot.model.message.*;
import com.linecorp.bot.model.message.template.*;
import com.linecorp.bot.model.action.*;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Muhammad Imam Fauzan
 * Model view untuk dikirimkan pada wellcome message, ketika Bot di invite / di follow
 * View yang berisi informasi media sosial Organisasi Assalam Polban.
 *
 */
public class MainViewBot {
	private final static String IMAGE_URL = "https://lh3.ggpht.com/Su-kBS_TEjK9ISAcAPNWMHL0OCNyiP56aeB5czxCqxgg3KrPfqL4qcRLJvwBjWummw=h310";
	private final static String TITLE = "Assalam Polban";
	private final static String CONTENT = "Silahkan Add/Follow sosial media kita yang lainnya :)";
	private final static String WELLCOME_MESSAGE = "Assalamu\'alaikum Wr. Wb.";
	
	private List<Action> actions;
	private Template buttonTemplate;
	private TemplateMessage viewMessage;
	
	public MainViewBot(){
		actions = Arrays.asList(
				new URIAction("Instagram", "https://www.instagram.com/assalampolban/"),
				new URIAction("Twitter", "https://www.twitter.com/assalampolban/"),
				new URIAction("Facebook", "https://www.facebook.com/assalampolban/"),
				new URIAction("LINE", "https://line.me/R/ti/p/%40LTA5871H")
		);
		
		buttonTemplate = new ButtonsTemplate(IMAGE_URL, TITLE, CONTENT, actions);
		viewMessage = new TemplateMessage(WELLCOME_MESSAGE, buttonTemplate);
	}

	public TemplateMessage getViewMessage() {
		return viewMessage;
	}
	
}
