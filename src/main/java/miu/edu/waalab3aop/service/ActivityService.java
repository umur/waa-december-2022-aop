package miu.edu.waalab3aop.service;

import miu.edu.waalab3aop.entity.Activity;
import miu.edu.waalab3aop.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity addActivity(Activity activity){
        return activityRepository.save(activity);
    }
}
