package com.yukproduktif.service;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

import retrofit2.Response;

public class LineBotService {
	
	@Autowired
    @Qualifier("com.linecorp.channel_access_token")
	private String channelAccessToken;
	
	public LineBotService(String accessToken){
		this.channelAccessToken = accessToken;
	}
	
	public LineBotService(){}
	
	public void setChannelAccessToken(String accessToken){
		this.channelAccessToken = accessToken;
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
