package com.yukproduktif.service;
import com.yukproduktif.model.Mosque;
import com.yukproduktif.model.MosqueResponse;
import java.util.List;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class MosqueService {
	private final static String URL = "http://botlineif.herokuapp.com/masjid/";
	public List<Mosque> FindMosque(){
		try {
			String response = Unirest.get(URL).asJson().getBody().toString();
			 Gson gson = new Gson();
		     MosqueResponse mosqueRes =  gson.fromJson(response, MosqueResponse.class);
		     return mosqueRes.mosques;
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
