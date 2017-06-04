package com.yukproduktif.service;
import com.yukproduktif.model.PrayerTimes;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;


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
	
	/**
	 * Get jadwal adzan dari service adzan 
	 * @return jadwal adzan
	 */
	public PrayerTimes getPrayerTimes(){
		Date now = new Date();
		String serviceURL = MessageFormat.format("{0}{1}/{2}/{3}/{4}", URL, now.getDate(), now.getMonth(), now.getYear(), LOCATION);
		
		try {
			JSONObject response = Unirest.get(serviceURL).asJson().getBody().getObject();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			
		    PrayerTimes adzan = new PrayerTimes(
		    		new Time(format.parse(response.getString("shubuh")).getTime()),
		    		new Time(format.parse(response.getString("sunrise")).getTime()),
		    		new Time(format.parse(response.getString("dzuhur")).getTime()),
		    		new Time(format.parse(response.getString("ashar")).getTime()),
		    		new Time(format.parse(response.getString("sunset")).getTime()),
		    		new Time(format.parse(response.getString("magrib")).getTime()),
		    		new Time(format.parse(response.getString("isya")).getTime())		    		
		    );
		    		
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
