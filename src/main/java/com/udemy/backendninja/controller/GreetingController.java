package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class GreetingController {

    private static final Log LOGGER = LogFactory.getLog(GreetingController.class);
    private static final String HELLO_WORLD_VIEW = "hello-world";

    //Endpoint: /say/greeting
    @GetMapping("/greeting")
    public String greet() {
        LOGGER.info("METHOD: greet -- TEMPLATE: " + HELLO_WORLD_VIEW);
        return HELLO_WORLD_VIEW;
    }
}
