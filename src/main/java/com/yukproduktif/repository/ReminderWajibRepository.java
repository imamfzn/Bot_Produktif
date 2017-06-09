package com.yukproduktif.repository;

import com.yukproduktif.model.ReminderWajib;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderWajibRepository extends IReminderRepository,  CrudRepository<ReminderWajib, String> {
	ReminderWajib findByUserId(String userId);
	
	@Query(value = "select r.reminder_user_id from reminder_wajib r where r.reminder_shubuh = true", nativeQuery = true)
	List<String> findByShubuh();
	
	@Query(value = "select r.reminder_user_id from reminder_wajib r where r.reminder_dzuhur = true", nativeQuery = true)
	List<String> findByDzuhur();
	
	@Query(value = "select r.reminder_user_id from reminder_wajib r where r.reminder_magrib = true", nativeQuery = true)
	List<String> findByMagrib();
	
	@Query(value = "select r.reminder_user_id from reminder_wajib r where r.reminder_isya = true", nativeQuery = true)
	List<String> findByAshar();
	
	@Query(value = "select r.reminder_user_id from reminder_wajib r where r.reminder_ashar = true", nativeQuery = true)
	List<String> findByIsya();
}
