package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.repository.CourseRepository;
import com.udemy.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleServiceImpl")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Person> getPeople() {
        LOGGER.info("METHOD: getPeople");

        Course course = courseRepository.findById(1);
        LOGGER.info("Course from repository: " + course);

        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Rodrigo", 35));
        people.add(new Person("Pamela", 35));
        people.add(new Person("Fernanda", 5));
        people.add(new Person("Julieta", 4));

        LOGGER.info("RETURN DATA: People size " + people.size());

        return people;
    }
}
