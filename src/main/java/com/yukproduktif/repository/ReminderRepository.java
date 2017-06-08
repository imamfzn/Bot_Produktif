package com.yukproduktif.repository;
import com.yukproduktif.model.Reminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends CrudRepository<Reminder, String> {
	Reminder findByUserId(String userId);
}
