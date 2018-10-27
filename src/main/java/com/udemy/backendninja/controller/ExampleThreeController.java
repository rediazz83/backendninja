package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/example-three")
public class ExampleThreeController {

    private static final Log LOGGER = LogFactory.getLog(ExampleThreeController.class);
    private static final String FORM_VIEW = "form";
    private static final String RESULT_VIEW = "result";

    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/example-three/show-form");
    }

    /*Endpoint: /example-three/show-form
    Generacion del from view*/
    @GetMapping("/show-form")
    public String showForm(Model model) {
        LOGGER.info("METHOD: showForm");

        model.addAttribute("person", new Person());

        LOGGER.info("TEMPLATE: " + FORM_VIEW);
        return FORM_VIEW;
    }

    //Endpoint: /example-three/add-person
    @PostMapping("/add-person")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        LOGGER.info("METHOD: addPerson -- PARAMS: " + person);

        ModelAndView response = null;

        if(bindingResult.hasErrors()) {
            response = setModelWithErrors();
        } else {
            response = setModelWithoutErrors(person);
        }

        return response;
    }

    //Endpoint: /example-three/catastrophic-error
    @GetMapping("/catastrophic-error")
    public String catastrophicError() {
        LOGGER.info("METHOD: showForm");

        String error = String.valueOf(5/0);
        return error;
    }

    private ModelAndView setModelWithErrors() {
        LOGGER.info("METHOD: setModelWithErrors");

        ModelAndView modelAndView = new ModelAndView(FORM_VIEW);

        LOGGER.error("TEMPLATE: " + FORM_VIEW);

        return modelAndView;
    }

    private ModelAndView setModelWithoutErrors(Person person) {
        LOGGER.info("METHOD: setModelWithErrors");

        ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
        modelAndView.addObject("person", person);

        LOGGER.info("TEMPLATE: " + RESULT_VIEW + " -- DATA: " + person);

        return modelAndView;
    }
}
