package com.yukproduktif.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.yukproduktif.model.BotReminder;

@Repository
public interface ReminderRepository extends CrudRepository<BotReminder,String>{
	List<BotReminder> findById(String userId);
}
