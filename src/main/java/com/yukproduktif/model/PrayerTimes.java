package com.yukproduktif.model;

import java.sql.Time;
import java.time.LocalTime;


public class PrayerTimes {
	private Time Shubuh;
	private Time Sunrise;
	private Time Dzuhur;
	private Time Ashar;
	private Time Sunset;
	private Time Magrib;
	private Time Isya;
	
	public PrayerTimes(Time shubuh, Time sunrise, Time dzuhur, Time ashar, Time sunset, Time magrib, Time isya) {
		Shubuh = shubuh;
		Sunrise = sunrise;
		Dzuhur = dzuhur;
		Ashar = ashar;
		Sunset = sunset;
		Magrib = magrib;
		Isya = isya;
	}
	
	@Override
	public String toString(){
		return this.Shubuh.toString() + this.Dzuhur.toString();
	}
	
	
	
}
