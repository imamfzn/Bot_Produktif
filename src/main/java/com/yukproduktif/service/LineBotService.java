package com.yukproduktif.service;
import java.io.IOException;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.yukproduktif.model.*;

import retrofit2.Response;

public class LineBotService {
	private String channelAccessToken;
	private Payload payload;
	
	public LineBotService(String channelAccessToken){
		this.channelAccessToken = channelAccessToken;
	}
	
	public void pushMessage(String sourceId, String message){
		TextMessage textMessage = new TextMessage(message);
	    PushMessage pushMessage = new PushMessage(sourceId,textMessage);
	    try {
	    	Response<BotApiResponse> response = LineMessagingServiceBuilder
	        .create(this.channelAccessToken)
	        .build()
	        .pushMessage(pushMessage)
	        .execute();
	        System.out.println(response.code() + " " + response.message());
	    } catch (IOException e) {
	    	System.out.println("Exception is raised ");
	        e.printStackTrace();
	    }
	}
	
	public void leaveGroup(String groupId, String type){
		try {
			if (type.equals("group")){
				Response<BotApiResponse> response = LineMessagingServiceBuilder
				.create(this.channelAccessToken)
				.build()
				.leaveGroup(groupId)
				.execute();
				System.out.println(response.code() + " " + response.message());
			} else if (type.equals("room")){
				Response<BotApiResponse> response = LineMessagingServiceBuilder
				.create(this.channelAccessToken)
				.build()
				.leaveRoom(groupId)
				.execute();
				System.out.println(response.code() + " " + response.message());
			}
		} catch (IOException e) {
			System.out.println("Exception is raised ");
			e.printStackTrace();
		}
	}

}
