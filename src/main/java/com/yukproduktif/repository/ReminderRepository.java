package com.yukproduktif.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yukproduktif.model.ReminderWajib;

@Repository
public interface ReminderRepository extends CrudRepository<ReminderWajib,String>{
	ReminderWajib findByUserId(String userId);
}
