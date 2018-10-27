package com.udemy.backendninja.controller;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    private static final Log LOGGER = LogFactory.getLog(ExampleController.class);
    public static final String EXAMPLE_VIEW = "example";

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent component;

    //Endpoint: /example/example-string
    @GetMapping("/example-string")
    public String exampleString(Model model) {
        LOGGER.info("METHOD: exampleString");

        component.sayHello();

        model.addAttribute("people", getPeople());

        LOGGER.info("TEMPLATE: " + EXAMPLE_VIEW + " DATA: people");
        return EXAMPLE_VIEW;
    }

    //Endpoint: /example/example-model-and-view
    @GetMapping("/example-model-and-view")
    public ModelAndView exampleModelAndView() {
        LOGGER.info("METHOD: exampleModelAndView");

        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("people", getPeople());

        LOGGER.info("TEMPLATE: " + EXAMPLE_VIEW + " DATA: people");
        return modelAndView;
    }

    private List<Person> getPeople() {
        LOGGER.info("METHOD: getPeople");

        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Rodrigo", 35));
        people.add(new Person("Pamela", 35));
        people.add(new Person("Fernanda", 5));
        people.add(new Person("Julieta", 4));

        LOGGER.info("RETURN DATA: People size " + people.size());

        return people;
    }
}
