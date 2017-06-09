package com.yukproduktif.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yukproduktif.model.ReminderSunnah;

@Repository
public interface ReminderSunnahRepository extends IReminderRepository, CrudRepository<ReminderSunnah, String>{
	ReminderSunnah findByUserId(String userId);
	
	@Query(value = "select r.reminder_user_id from reminder_sunnah1 r where r.reminder_dhuha = true", nativeQuery = true)
	List<String> findByDhuha();
	
	@Query(value = "select r.reminder_user_id from reminder_sunnah1 r where r.reminder_tahajud = true", nativeQuery = true)
	List<String> findByTahajud();
}
