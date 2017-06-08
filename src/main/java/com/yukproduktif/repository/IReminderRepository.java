package com.yukproduktif.repository;
import com.yukproduktif.model.IReminder;

public interface IReminderRepository {
	IReminder findByUserId(String userId);
	IReminder save(IReminder reminder);
}
