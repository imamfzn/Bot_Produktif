package com.yukproduktif.service;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

import retrofit2.Response;

/**
 * 
 * @author Muhammad Imam Fauzan
 * @purpose Class service untuk menangani komunikasi pengiriman data ke API LINE Messaging
 *
 */
public class LineBotService {

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
	
	public void replyToUser(String rToken, String messageToUser){
        TextMessage textMessage = new TextMessage(messageToUser);
        ReplyMessage replyMessage = new ReplyMessage(rToken, textMessage);
        try {
            Response<BotApiResponse> response = LineMessagingServiceBuilder
                .create(this.channelAccessToken)
                .build()
                .replyMessage(replyMessage)
                .execute();
            System.out.println("Reply Message: " + response.code() + " " + response.message());
        } catch (IOException e) {
            System.out.println("Exception is raised ");
            e.printStackTrace();
        }
    }
	
	public void sendTemplateMessage(String sourceId, TemplateMessage message){
        PushMessage pushMessage = new PushMessage(sourceId,message);
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
