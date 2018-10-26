package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
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

    public static final String EXAMPLE_VIEW = "example";

    //Endpoint: /example/example-string
    @GetMapping("/example-string")
    public String exampleString(Model model) {
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    //Endpoint: /example/example-model-and-view
    @GetMapping("/example-model-and-view")
    public ModelAndView exampleModelAndView() {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("people", getPeople());
        return modelAndView;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Rodrigo", 35));
        people.add(new Person("Pamela", 35));
        people.add(new Person("Fernanda", 5));
        people.add(new Person("Julieta", 4));

        return people;
    }
}
