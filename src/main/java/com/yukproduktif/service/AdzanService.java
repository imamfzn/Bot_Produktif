package com.yukproduktif.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import java.time.LocalTime;

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
 * Menangani pengambilan data ke service adzan
 *
 */
public class AdzanService {
	private static final String URL = "https://adzanservice.herokuapp.com/get_adzan/";
	private static final String LOCATION = "bandung";
	public AdzanService(){};
	
	public PrayerTimes getPrayerTimes(){
		Date now = new Date();
		String serviceURL = this.URL + now.getDate() + "/" + now.getMonth() + "/" + now.getYear() + "/" + this.LOCATION;
		
		try {
			JSONObject response = Unirest.get(serviceURL).asJson().getBody().getObject();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			
		    PrayerTimes adzan = new PrayerTimes(
		    		new Time(format.parse(response.getString("Shubuh")).getTime()),
		    		new Time(format.parse(response.getString("Sunrise")).getTime()),
		    		new Time(format.parse(response.getString("Dzuhur")).getTime()),
		    		new Time(format.parse(response.getString("Ashar")).getTime()),
		    		new Time(format.parse(response.getString("Sunset")).getTime()),
		    		new Time(format.parse(response.getString("Magrib")).getTime()),
		    		new Time(format.parse(response.getString("Isya")).getTime())		    		
		    );
		    		
			System.out.println(adzan.toString());
			return adzan;

		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;		
	}

}
