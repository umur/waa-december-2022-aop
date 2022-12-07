package edu.miu.springaop.repository;

import edu.miu.springaop.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog,Long> {

}
