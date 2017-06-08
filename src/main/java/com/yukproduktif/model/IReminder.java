package com.yukproduktif.model;

public interface IReminder {
	boolean isActive(String prayerName);
	void setReminder(String prayerName, boolean newStatus);
}
