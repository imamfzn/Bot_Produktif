package com.yukproduktif.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sunnah_times")
public class SunnahPrayerTimes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_sunnah")
	private int id;
	
	@Column(name = "nama_sunnah")
	private String nama;
	
	@Column(name = "waktu_sunnah")
	private Time waktu;
	
	
	
}
