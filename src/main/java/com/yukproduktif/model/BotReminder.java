package com.yukproduktif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reminder")
public class BotReminder {
	
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
}
