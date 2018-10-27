package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example-two")
public class ExampleTwoController {

    private static final Log LOGGER = LogFactory.getLog(ExampleTwoController.class);
    public static final String EXAMPLE_TWO_VIEW = "example-two";

    //Endpoint: /example-two/request-one?name={name}&lastName={lastName}
    @GetMapping("/request-one")
    public ModelAndView requestOne(@RequestParam(name = "name", required = false, defaultValue = "Anonimo") String name,
                                   @RequestParam(name = "lastName", required = false, defaultValue = "Anonimo") String lastName) {
        LOGGER.info("METHOD: requestOne -- PARAMS: " + name + ", " + lastName);

        ModelAndView modelAndView = new ModelAndView(EXAMPLE_TWO_VIEW);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastName", lastName);

        LOGGER.info("TEMPLATE: " + EXAMPLE_TWO_VIEW + " DATA: " + name + ", " + lastName);
        return modelAndView;
    }

    //Endpoint: /example-two/request-two/{name}::{lastName}
    @GetMapping("/request-two/{name}::{lastName}")
    public ModelAndView requestTwo(@PathVariable("name") String name,
                                   @PathVariable("lastName") String lastName) {
        LOGGER.info("METHOD: requestTwo -- PARAMS: " + name + ", " + lastName);

        ModelAndView modelAndView = new ModelAndView(EXAMPLE_TWO_VIEW);
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastName", lastName);

        LOGGER.info("TEMPLATE: " + EXAMPLE_TWO_VIEW + " -- DATA: " + name + ", " + lastName);
        return modelAndView;
    }
}
