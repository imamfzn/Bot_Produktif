package com.yukproduktif.model.view;
import com.yukproduktif.model.Mosque;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.linecorp.bot.model.action.*;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.message.template.Template;


public class MosqueView {
	
	private final static String TITLE = "Masjid Terdekat";
	private final static String IMG = "https://www.moonsighting.com/images/mosques/siddiqa_fatima_zahra_mosque_kuwait.jpg";
	private List<CarouselColumn> columns;
	private Template carousel;
	private TemplateMessage viewMessage;

	public MosqueView(List<Mosque> mosques){
		columns = new ArrayList<CarouselColumn>();
		for (Mosque m : mosques){
			List<Action> actions = Arrays.asList(new URIAction("Lihat Lokasi", m.gmapsUrl)); //cannot direct cast to List<Action>
			columns.add(new CarouselColumn(m.photoUrl == "x" ? IMG : m.photoUrl ,m.name,m.address == null? m.distance : m.address, actions));
		}

		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
				
	}
	
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	

}
