package com.ticketingapplication.controller;
import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.service.RoleService;
import com.ticketingapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());


        return "/user/create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("userDTO") UserDTO user){
        userService.save(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String getUser(@PathVariable("username") String username, Model model){
        model.addAttribute("existingUser", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("existingUser") UserDTO existingUser){
        userService.update(existingUser);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String getUserToDelete(@PathVariable("username") String username){
        userService.deleteById(username);

return "redirect:/user/create";
    }

}
