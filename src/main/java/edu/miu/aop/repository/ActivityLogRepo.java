package edu.miu.aop.repository;

import edu.miu.aop.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ankhbayar Azzaya
 */
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
