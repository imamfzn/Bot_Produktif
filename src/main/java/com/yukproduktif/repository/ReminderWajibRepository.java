package com.yukproduktif.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yukproduktif.model.ReminderWajib;

@Repository
public interface ReminderWajibRepository extends CrudRepository<ReminderWajib,String>{
	ReminderWajib findByUserId(String userId);
}
