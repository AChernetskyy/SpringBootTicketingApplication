package com.ticketingapplication.service;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface ProjectService extends CrudService<ProjectDTO, String>{
    void complete(ProjectDTO project);

    List<ProjectDTO>getCountedTaskListOfProjects(UserDTO manager);
}
