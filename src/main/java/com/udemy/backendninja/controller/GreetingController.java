package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class GreetingController {


    //Endpoint: /say/greeting
    @GetMapping("/greeting")
    public String greet() {
        return "hello-world";
    }
}
