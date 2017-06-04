package com.yukproduktif.service;

import java.sql.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.yukproduktif.model.DataReminder;
import com.yukproduktif.model.Mosque;
import com.yukproduktif.model.MosqueResponse;

public class MosqueService {
	private final static String URL = "http://botlineif.herokuapp.com/masjid/";
	public String FindMosques(){
		try {
			String response = Unirest.get(URL).asJson().getBody().toString();
			 Gson gson = new Gson();
		     MosqueResponse mosqueRes =  gson.fromJson(response, MosqueResponse.class); //return response;
		     System.out.println(mosqueRes.mosques.size() + mosqueRes.mosques.toString());
		     return response;
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
