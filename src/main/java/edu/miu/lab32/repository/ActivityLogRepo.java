package edu.miu.lab32.repository;

import edu.miu.lab32.model.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
