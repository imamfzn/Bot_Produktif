package com.yukproduktif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reminder")
public class ReminderWajib {
	
	@Id
	@Column(name = "reminder_user_id")
	private String userId;
	
	@Column(name = "reminder_shubuh")
	private boolean shubuh;
	
	@Column(name = "reminder_dzuhur")
	private boolean dzuhur;
	
	@Column(name = "reminder_ashar")
	private boolean ashar;
	
	@Column(name = "reminder_magrib")
	private boolean magrib;
	
	@Column(name = "reminder_isya")
	private boolean isya;
	
	public ReminderWajib(){}
	
	public ReminderWajib(String userId){
		this.userId = userId;
	}

	public ReminderWajib(String userId, boolean shubuh, boolean dzuhur, boolean ashar, boolean magrib, boolean isya) {
		this.userId = userId;
		this.shubuh = shubuh;
		this.dzuhur = dzuhur;
		this.ashar = ashar;
		this.magrib = magrib;
		this.isya = isya;
	}
	
	
	public boolean isShubuhActive() {
		return shubuh;
	}

	public void setShubuh(boolean shubuh) {
		this.shubuh = shubuh;
	}

	public boolean isDzuhurActive() {
		return dzuhur;
	}

	public void setDzuhur(boolean dzuhur) {
		this.dzuhur = dzuhur;
	}

	public boolean isAsharActive() {
		return ashar;
	}

	public void setAshar(boolean ashar) {
		this.ashar = ashar;
	}

	public boolean isMagribActive() {
		return magrib;
	}

	public void setMagribActive(boolean magrib) {
		this.magrib = magrib;
	}

	public boolean isIsyaActive() {
		return isya;
	}

	public void setIsya(boolean isya) {
		this.isya = isya;
	}

	public String getUserId() {
		return userId;
	}
	
	private void setAllReminder(boolean status){
		shubuh = dzuhur = ashar = magrib = isya = status;
	}
	
	public boolean isActive(String adzanName){
		switch(adzanName){
			case "shubuh" : return shubuh;
			case "dzuhur" : return dzuhur;
			case "ashar" : return ashar; 
			case "magrib" : return magrib;
			case "isya" : return isya;
		}
		return false;
	}
	
	public void setReminder(String adzanName, boolean status){
		switch(adzanName){
			case "shubuh" : shubuh = status; break;
			case "dzuhur" : dzuhur = status; break;
			case "ashar" : ashar = status; break;
			case "magrib" : magrib = status; break;
			case "isya" : isya = status; break;
		}
	}

	public void setAllActive(){
		setAllReminder(true);
	}
	
	public void setAllNonActive(){
		setAllReminder(false);
	}
	
	
}
