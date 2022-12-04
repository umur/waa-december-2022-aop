package edu.miu.repository;

import edu.miu.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

}
