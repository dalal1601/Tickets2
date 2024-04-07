package com.example.tickets2.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "Home";
    }
}
