package com.yukproduktif.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yukproduktif.model.ReminderSunnah;

@Repository
public interface ReminderSunnahRepository extends IReminderRepository, CrudRepository<ReminderSunnah, String>{
	ReminderSunnah findByUserId(String userId);
}
