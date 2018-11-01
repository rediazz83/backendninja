package com.udemy.backendninja.controller;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public static final String COURSES_VIEW = "courses";
    private static final Log LOGGER = LogFactory.getLog(CourseController.class);

    //Endpoint: /courses/list-courses
    @GetMapping("/list-courses")
    public ModelAndView listAllCourses() {
        LOGGER.info("METHOD: listAllCourses");

        ModelAndView response = new ModelAndView(COURSES_VIEW);
        response.addObject("courses", courseService.listAllCourses());

        LOGGER.info("TEMPLATE: " + COURSES_VIEW);
        return response;
    }

    @PostMapping("/add-course")
    public RedirectView addCourse(@ModelAttribute("course")Course course) {
        LOGGER.info("METHOD: addCourse -- PARAMS: " + course);

        courseService.addCourse(course);
        return new RedirectView("/courses/list-courses");
    }
}
