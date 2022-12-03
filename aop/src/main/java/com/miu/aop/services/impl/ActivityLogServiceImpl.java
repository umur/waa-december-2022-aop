package com.miu.aop.services.impl;

import com.miu.aop.entities.ActivityLog;
import com.miu.aop.entities.dto.ActivityLogDto;
import com.miu.aop.repositories.ActivityLogRepo;
import com.miu.aop.services.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<ActivityLogDto> getAll() {
        return activityLogRepo.findAll().stream().map(x -> modelMapper.map(x, ActivityLogDto.class)).toList();
    }

    @Override
    public ActivityLogDto getById(int id) {
        return modelMapper.map(activityLogRepo.findById(id).orElseThrow(() -> new RuntimeException("Activity Log with id " + id + " does not exist")), ActivityLogDto.class);
    }

    @Override
    public ActivityLogDto save(ActivityLogDto activityLogDto) {
        ActivityLog activityLog = modelMapper.map(activityLogDto, ActivityLog.class);
        return modelMapper.map(activityLogRepo.save(activityLog), ActivityLogDto.class);
    }

}
