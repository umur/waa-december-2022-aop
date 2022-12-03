package com.miu.aop.services;

import com.miu.aop.entities.dto.ActivityLogDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityLogService {
    List<ActivityLogDto> getAll();
    ActivityLogDto getById(int id);
    ActivityLogDto save(ActivityLogDto activityLogDto);
//    void delete(int id);
//    ActivityLogDto update(int id, ActivityLogDto activityLogDto);
}
