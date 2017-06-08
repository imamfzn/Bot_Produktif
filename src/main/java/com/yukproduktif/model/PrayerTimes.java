package com.yukproduktif.model;

import java.sql.Time;
import java.util.Date;


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
	
	@Override
	public String toString(){
		Date now = new Date();
		String format = "Jadwal adzan hari ini " + now.toString() + " di Bandung:\n"
				+ "Shubuh  : " + this.shubuh.toString() + "\n"
				+ "Dzuhur  : " + this.dzuhur.toString() + "\n"
				+ "Ashar   : " + this.ashar.toString() + "\n"
				+ "Maghrib : " + this.magrib.toString() + "\n"
				+ "Isya    : " + this.isya.toString() + "\n";
		return format;
	}
	
	
}
