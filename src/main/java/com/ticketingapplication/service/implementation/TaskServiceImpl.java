package com.ticketingapplication.service.implementation;

import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.service.TaskService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TaskServiceImpl extends AbstractMapService<Long, TaskDTO> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
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
    public void delete(TaskDTO object) {


    }

    @Override
    public void update(TaskDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }
}
