package edu.miu.springaop.Service.Impl;

import edu.miu.springaop.Dto.ActivityLogDto;
import edu.miu.springaop.Repository.ActivityLogRepo;
import edu.miu.springaop.Service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Collection;
import java.util.List;

import edu.miu.springaop.entity.ActivityLog;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl  implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;
    private final ModelMapper mapper;
    @Override
    public List<ActivityLogDto> getAll() {
        return activityLogRepo.findAll().stream().map(x -> mapper.map(x, ActivityLogDto.class)).toList();
    }
//    @Override
//    public List<ActivityLog> getAll() {
//        return activityLogRepo.findAll();
//    }


    @Override
    public ActivityLogDto getById(int id) {
        return mapper.map(activityLogRepo.findById(id).orElseThrow(() -> new RuntimeException("Activity Log does not exist")), ActivityLogDto.class);
    }

    @Override
    public ActivityLogDto save(ActivityLogDto activityLogDto) {
        ActivityLog activityLog = mapper.map(activityLogDto, ActivityLog.class);
        //activityLogRepo.save(activityLog);
        return mapper.map(activityLogRepo.save(activityLog), ActivityLogDto.class);
    }
}
