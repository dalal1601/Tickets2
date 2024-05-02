package com.example.tickets2.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String home(){
        return "redirect:/home";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/AccessDenied";
    }
    @GetMapping("/login")
    public String login(){
        return "/Login";
    }

}
