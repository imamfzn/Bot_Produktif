package com.yukproduktif.repository;
import com.yukproduktif.model.IReminder;
import org.springframework.data.repository.CrudRepository;

public interface ReminderRepository<T extends IReminder> extends CrudRepository<T, String> {
	T findByUserId(String userId);
}
