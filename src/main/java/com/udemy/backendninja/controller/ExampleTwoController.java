package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example-two")
public class ExampleTwoController {

    public static final String EXAMPLE_TWO_VIEW = "example-two";

    //Endpoint: /example-two/request-one?name={name}&lastName={lastName}
    @GetMapping("/request-one")
    public ModelAndView requestOne(@RequestParam(name = "name", required = false, defaultValue = "Anonimo") String name,
                                   @RequestParam(name = "lastName", required = false, defaultValue = "Anonimo") String lastName) {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_TWO_VIEW);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    //Endpoint: /example-two/request-two/{name}::{lastName}
    @GetMapping("/request-two/{name}::{lastName}")
    public ModelAndView requestTwo(@PathVariable("name") String name,
                                   @PathVariable("lastName") String lastName) {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_TWO_VIEW);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }
}
