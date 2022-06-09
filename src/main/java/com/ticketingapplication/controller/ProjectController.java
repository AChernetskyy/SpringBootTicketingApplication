package com.ticketingapplication.controller;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

   private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("findAllManagers", projectService.)

        return "/project/create";
    }
}
