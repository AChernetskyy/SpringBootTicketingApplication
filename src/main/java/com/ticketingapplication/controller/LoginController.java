package com.ticketingapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping(value = {"/login", "/"})
    public String login(){
        return "/login";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "/welcome";
    }
}
