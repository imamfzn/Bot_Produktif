package com.yukproduktif.model.view;
import com.yukproduktif.model.Mosque;
import java.util.Arrays;
import java.util.List;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.message.template.Template;


public class MosqueView {
	
	private final static String TITLE = "Masjid Terdekat";
	
	private List<CarouselColumn> columns;
	private Template carousel;
	private TemplateMessage viewMessage;
	
	public MosqueView(){}
	public MosqueView(List<Mosque> mosques){
		
		for (Mosque m : mosques){
			columns.add(new CarouselColumn(m.photoUrl,m.name,m.address, Arrays.asList(new URIAction("Lihat Lokasi", m.gmapsUrl))));
		}
		
		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
				
	}
	
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	

}
