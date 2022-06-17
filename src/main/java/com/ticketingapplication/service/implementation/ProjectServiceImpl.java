package com.ticketingapplication.service.implementation;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.enums.Status;
import com.ticketingapplication.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<String, ProjectDTO> implements ProjectService {
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
    public void delete(ProjectDTO object) {
    }

    @Override
    public void update(ProjectDTO object) {
       super.update(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }
    public void complete(String id){
        super.findById(id).setProjectStatus(Status.COMPLETE);
    }
}
