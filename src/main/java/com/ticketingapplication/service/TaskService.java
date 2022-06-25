package com.ticketingapplication.service;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long>{
    List<TaskDTO>findTasksByManager(UserDTO manager);
}
