package com.yukproduktif.model;

import java.sql.Time;
import java.time.LocalTime;


public class PrayerTimes {
	private Time shubuh;
	private Time sunrise;
	private Time dzuhur;
	private Time ashar;
	private Time sunset;
	private Time magrib;
	private Time isya;
	
	public PrayerTimes(Time shubuh, Time sunrise, Time dzuhur, Time ashar, Time sunset, Time magrib, Time isya) {
		this.shubuh = shubuh;
		this.sunrise = sunrise;
		this.dzuhur = dzuhur;
		this.ashar = ashar;
		this.sunset = sunset;
		this.magrib = magrib;
		this.isya = isya;
	}
	
	
}
