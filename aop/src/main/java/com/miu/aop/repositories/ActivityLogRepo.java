package com.miu.aop.repositories;

import com.miu.aop.entities.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog, Integer> {
}
