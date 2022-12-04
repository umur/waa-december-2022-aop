package edu.miu.springaop.Service;

import edu.miu.springaop.Dto.ActivityLogDto;
import edu.miu.springaop.Repository.ActivityLogRepo;
import edu.miu.springaop.entity.ActivityLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service

public interface ActivityLogService {

    public  List<ActivityLogDto> getAll();
    //public List<ActivityLog> getAll();
    ActivityLogDto getById(int id);
    //ActivityLogDto
    ActivityLogDto save(ActivityLogDto activityLogDto);
}
