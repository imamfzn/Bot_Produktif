package com.yukproduktif.repository;

import com.yukproduktif.model.ReminderWajib;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepositoryWajib extends IReminderRepository,  CrudRepository<ReminderWajib, String> {
	ReminderWajib findByUserId(String userId);
}
