package edu.miu.springaop.Repository;

import edu.miu.springaop.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepo extends CrudRepository <ActivityLog,Integer>{
    //public ActivityLog getActivityLogById(int id);
    public List<ActivityLog> findAll();


}
