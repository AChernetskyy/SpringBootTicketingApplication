package com.ticketingapplication.controller;

import com.ticketingapplication.dto.TaskDTO;
import com.ticketingapplication.service.ProjectService;
import com.ticketingapplication.service.TaskService;
import com.ticketingapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String saveTask(TaskDTO taskDTO) {
        taskService.save(taskDTO);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}") //end point with ID
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("readCurrentTask", taskService.findById(id));
        model.addAttribute("readAllTasks", taskService.findAll());
        model.addAttribute("readAllProject", projectService.findAll());
        model.addAttribute("readAllEmployees", userService.readAllEmployees());

        return "/task/update"; //navigate to HTML
    }

    //    @PostMapping("/update/{taskId}")
//    public String postUpdate(@PathVariable("taskId") Long id, @ModelAttribute("readCurrentTask") TaskDTO taskDTO){
//        taskDTO.setId(id);// Setting ID to avoid NullPointerException
//        taskService.update(taskDTO);
//        return "redirect:/task/create";
//    }
    //Short Cut for the same method
    @PostMapping("/update/{id}")//{id} must match variable in the Class TaskDTO and Spring will match and set it
    public String postUpdate(TaskDTO taskDTO) {
        taskService.update(taskDTO);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

    @GetMapping("/pending-tasks")
    public String getEmployeePendingTasks(Model model){
        //taskService.findTasksByEmployee()

        return "/task/pending-tasks";
    }

    @GetMapping("/archive")
    public String getArchiveTasks(){
        return "task/archive";
    }
}
