package edu.miu.labthree.repository;

import edu.miu.labthree.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}
