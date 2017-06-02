package com.yukproduktif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Muhammad Imam Fauzan, 
 * Model untuk tabel reminder ibadah sunnah.
 *
 */

@Entity
@Table(name = "reminder_sunnah")
public class ReminderSunnah {
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "id_sunnah")
	private int id_sunnah;
	
	
}
