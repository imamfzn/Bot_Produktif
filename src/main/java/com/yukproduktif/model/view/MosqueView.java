package com.yukproduktif.model.view;
import com.yukproduktif.model.Mosque;
import java.util.Arrays;
import java.util.List;

import com.linecorp.bot.model.action.Action;
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

	public MosqueView(List<Mosque> mosques){
	
		/*for (Mosque m : mosques){
			new CarouselColumn(IMAGE_URL_SHUBUH,"Waktu Shubuh","04:30 am", actions),
			columns.add(
					new CarouselColumn("https://igx.4sqi.net/img/general/640x480/2210732_zMw-UepPzeQSrpEy2KZgSFaWNA6Vg4l1ztAB99Bc6lY.jpg",m.name,"test address", Arrays.asList(new URIAction("Lihat Lokasi", m.gmapsUrl))));
			//System.out.println("test");
		}*/
		String img_url = "https://igx.4sqi.net/img/general/640x480/2210732_zMw-UepPzeQSrpEy2KZgSFaWNA6Vg4l1ztAB99Bc6lY.jpg";
		List<Action> actions = Arrays.asList(new URIAction("Yuk Shalat! :)", "https://line.me/R/ti/p/%40LTA5871H"));
		columns = Arrays.asList(new CarouselColumn(img_url,mosques.get(0).name,"alamat", actions ));
		
		carousel = new CarouselTemplate(columns);
		viewMessage = new TemplateMessage(TITLE, carousel);
				
	}
	
	public TemplateMessage getViewMessage(){
		return viewMessage;
	}
	

}
