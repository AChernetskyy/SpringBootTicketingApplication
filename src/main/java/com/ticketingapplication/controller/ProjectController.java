package com.ticketingapplication.controller;

import com.ticketingapplication.dto.ProjectDTO;
import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.service.ProjectService;
import com.ticketingapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("findAllManagers", userService.findAllManagers());
        model.addAttribute("allProjects", projectService.findAll());

        return "/project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project") ProjectDTO projectDTO) {
        projectService.save(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String updateProject(@PathVariable("projectCode") String projectCode, Model model) {
        model.addAttribute("existingProject", projectService.findById(projectCode));
        model.addAttribute("allProjects", projectService.findAll());
        model.addAttribute("allManagers", userService.findAllManagers());
        return "/project/update";
    }

    @PostMapping("/update")
    public String postUpdates(ProjectDTO project) {
        projectService.save(project);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") String id){
        projectService.deleteById(id);
        return "redirect:/project/create";
    }
    @GetMapping("/complete/{id}")
    public String completeProject(@PathVariable("id") String id){
     projectService.complete(projectService.findById(id));
     return "redirect:/project/create";
    }

    @GetMapping("/manager/project-status")
    public String getProjectStatus(Model model){
        UserDTO manager= userService.findById("john@cydeo.com");
        List<ProjectDTO> projects = projectService.getCountedTaskListOfProjects(manager);
        model.addAttribute("projects", projects);
        return "/manager/project-status";
    }

    @GetMapping("/manager/complete/{projectCode}")
    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/manager/project-status";
    }
}
