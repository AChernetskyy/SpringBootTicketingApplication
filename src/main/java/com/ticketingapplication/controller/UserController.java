package com.ticketingapplication.controller;

import com.ticketingapplication.dto.RoleDTO;
import com.ticketingapplication.dto.UserDTO;
import com.ticketingapplication.enums.Gender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("userDTO", new UserDTO());
        //model.addAttribute("role", new RoleDTO());


        return "/user/create";
    }
}
