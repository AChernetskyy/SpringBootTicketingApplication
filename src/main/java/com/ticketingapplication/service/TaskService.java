package com.ticketingapplication.service;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.enums.Status;

import java.util.List;
import java.util.Stack;

public interface TaskService extends CrudService<TaskDTO, Long>{
    List<TaskDTO>findTasksByManager(UserDTO manager);
    List<TaskDTO>findTasksByEmployee(UserDTO employee);
    List<TaskDTO>findPendingTasksByEmployee(Status status);
}
