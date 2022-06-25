package com.ticketingapplication.service.implementation;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.enums.Status;
import com.ticketingapplication.service.TaskService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskServiceImpl extends AbstractMapService<Long, TaskDTO> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getTaskStatus()==null){
            object.setTaskStatus(Status.OPEN);
        }
        if(object.getTimeCreated()==null){
            object.setTimeCreated(LocalDate.now());
        }
        if(object.getId()==null){
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public void update(TaskDTO object) {
        TaskDTO findTask=findById(object.getId());
        object.setTaskStatus(findTask.getTaskStatus());
        object.setTimeCreated(findTask.getTimeCreated());
        super.update(object.getId(), object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }


    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream().filter(p->p.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }
}
