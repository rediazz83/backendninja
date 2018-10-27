package com.udemy.backendninja.controller;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    private static final Log LOGGER = LogFactory.getLog(ExampleController.class);
    public static final String EXAMPLE_VIEW = "example";

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent component;

    @Autowired
    @Qualifier("exampleServiceImpl")
    private ExampleService service;

    //Endpoint: /example/example-string
    @GetMapping("/example-string")
    public String exampleString(Model model) {
        LOGGER.info("METHOD: exampleString");

        component.sayHello();

        model.addAttribute("people", service.getPeople());

        LOGGER.info("TEMPLATE: " + EXAMPLE_VIEW + " -- DATA: people");
        return EXAMPLE_VIEW;
    }

    //Endpoint: /example/example-model-and-view
    @GetMapping("/example-model-and-view")
    public ModelAndView exampleModelAndView() {
        LOGGER.info("METHOD: exampleModelAndView");

        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("people", service.getPeople());

        LOGGER.info("TEMPLATE: " + EXAMPLE_VIEW + " -- DATA: people");
        return modelAndView;
    }
}
