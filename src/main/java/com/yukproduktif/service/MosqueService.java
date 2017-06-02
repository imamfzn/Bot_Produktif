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
import com.yukproduktif.model.Masjid;
import com.yukproduktif.model.PrayerTimes;

public class MosqueService {
	private final static String URL = "http://botlineif.herokuapp.com/masjid/";
	public MosqueService(){};
	public List<Masjid> FindMosques(){
		try {
			String response = Unirest.get(URL).asJson().getBody().getObject().toString();
			 Gson gson = new Gson();
			 List<Masjid> mosques = (List<Masjid>) gson.fromJson(response, Masjid.class);
			 
			 return mosques;

		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
