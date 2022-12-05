package edu.miu.lab5.repo;

import edu.miu.lab5.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {

}
