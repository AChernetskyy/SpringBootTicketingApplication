package com.ticketingapplication.controller;

import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.service.ProjectService;
import com.ticketingapplication.service.TaskService;
import com.ticketingapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final UserService userService;
    private final TaskService taskService;
    private final ProjectService projectService;

    public TaskController(UserService userService, TaskService taskService, ProjectService projectService) {
        this.userService = userService;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newTask", new TaskDTO());
        model.addAttribute("readAllEmployees", userService.readAllEmployees());
        model.addAttribute("readAllTasks", taskService.findAll());
        model.addAttribute("readAllProjects", projectService.findAll());
        return "/task/create";
    }

    @PostMapping("/create")
    public String saveTask(TaskDTO taskDTO){
        taskService.save(taskDTO);
        return "redirect:/task/create";
    }
}
