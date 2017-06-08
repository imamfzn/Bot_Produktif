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
public class ReminderSunnah implements IReminder {
	@Id
	@Column(name = "reminder_user_id")
	private String userId;
	
	@Column(name = "reminder_dhuha")
	private boolean dhuha;
	
	@Column(name = "reminder_tahajud")
	private boolean tahajud;
	
	public ReminderSunnah(){}
	
	private void setAllReminder(boolean status) {
		dhuha = tahajud = status;
	}
	
	public void setAllActive(){
		setAllReminder(true);
	}

	public void setAllNonActive(){
		setAllReminder(false);
	}
	
	public boolean isActive(String name){
		switch(name){
			case "dhuha" : return dhuha;
			case "tahajud" : return tahajud;
		}
		return false;
	}
	
	public void setReminder(String name, boolean status){
		switch(name){
			case "dhuha" : dhuha = status; break;
			case "tahajud" : tahajud = status; break;
		}
	}
}
