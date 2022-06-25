package com.ticketingapplication.service.implementation;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.enums.Status;
import com.ticketingapplication.service.ProjectService;
import com.ticketingapplication.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<String, ProjectDTO> implements ProjectService {
    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        if(object.getProjectStatus()==null){
            object.setProjectStatus(Status.OPEN);
        }
        return super.save(object.getProjectCode(),object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
      super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO object) {
       super.update(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO project) {
     project.setProjectStatus(Status.COMPLETE);
    }

    @Override
    /*
    Building Project List page visible by Manager
    And Filtering all projects based on the manager
     */
    public List<ProjectDTO> getCountedTaskListOfProjects(UserDTO manager) {
        List<ProjectDTO> projectList = findAll().
                stream().
                filter(project->project.getAssignedManager().equals(manager)).//First filter to find assigned manager
                map(projectDTO -> {   //Then we use MAP to count tasks, needed fo the UI

                    List<TaskDTO>allTasks=taskService.findTasksByManager(manager);

                    int completedTasks=(int)allTasks.stream().filter(p->p.getProject().equals(projectDTO)&&p.getTaskStatus().equals(Status.COMPLETE)).count();

                    int unfinishedTasks=(int)allTasks.stream().filter(p->p.getProject().equals(projectDTO) && !p.getTaskStatus().equals(Status.COMPLETE)).count();

                    projectDTO.setCompletedTaskCounts(completedTasks); // Building constructor by setting this field
                    projectDTO.setUnfinishedTaskCounts(unfinishedTasks); // Building constructor by setting this field
                    return projectDTO;
                }).collect(Collectors.toList());

        return projectList;
    }

}
