package com.yukproduktif.model;

/**
 * 
 * @author Muhammad Imam Fauzan
 * Untuk merepesentasikan data masjid, 
 * Akan digunakan untuk fitur pencarian masjid terdekat oleh Service Masjid
 */
public class Mosque_ {
	private Double latitude;
	private Double longitude;
	private String name;
	private String address;
	private String image_url;
	
	public Mosque_(Double latitude, Double longitude, String name, String address, String image_url) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.address = address;
		this.image_url = image_url;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
	
}
