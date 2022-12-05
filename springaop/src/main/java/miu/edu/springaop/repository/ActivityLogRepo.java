package miu.edu.springaop.repository;

import miu.edu.springaop.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
