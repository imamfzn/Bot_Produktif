package com.yukproduktif.service;
import java.util.Date;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;
import org.json.JSONObject;

import com.yukproduktif.model.Payload;
import com.yukproduktif.model.PrayerTimes;

/**
 * 
 * @author Muhammad Imam Fauzan
 * @purpose Menangani pengambilan data ke service adzan
 *
 */
public class AdzanService {
	private static final String URL = "https://adzanservice.herokuapp.com/get_adzan?";
	private static final String LOCATION = "bandung";
	public AdzanService(){};
	
	/**
	 * To-do:
	 * Ambil data adzan lewat endpoint service adzan
	 * @param date
	 * @return
	 */
	public String getPrayerTimes(){
		Date now = new Date();
		String serviceURL = this.URL + 
				"tanggal=" + now.getDate() + 
				"&&bulan=" + now.getMonth() + 
				"&&tahun=" + now.getYear() + 
				"&&lokasi=" + this.LOCATION;
		
		try {
			String response = Unirest.get(serviceURL).asString().getBody();
			//Gson gson = new Gson();
		    //PrayerTimes adzan = gson.fromJson(response, PrayerTimes.class);
			
			return response;
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
