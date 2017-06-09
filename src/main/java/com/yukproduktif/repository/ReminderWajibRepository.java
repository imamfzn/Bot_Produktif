package com.yukproduktif.repository;

import com.yukproduktif.model.ReminderWajib;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderWajibRepository extends IReminderRepository,  CrudRepository<ReminderWajib, String> {
	ReminderWajib findByUserId(String userId);
	
	@Query("select r.reminder_user_id from reminder_wajib r where r.reminder_shubuh = t")
	List<String> findUserHasActivatedShubuh();
}
