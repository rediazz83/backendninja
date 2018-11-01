package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseRepository;
import com.udemy.backendninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> listAllCourses() {
        LOGGER.info("METHOD: listAllCourses");

        List<Course> courses = courseRepository.findAll();

        LOGGER.info("DATA SIZE RETURN: " + courses.size());
        return courses;
    }

    @Override
    public Course addCourse(Course course) {
        LOGGER.info("METHOD: addCourse -- PARAMS: " + course);

        Course thisCourse = courseRepository.save(course);

        LOGGER.info("DATA RETURN: " + thisCourse);
        return thisCourse;
    }

    @Override
    public Course updateCourse(Course course) {
        LOGGER.info("METHOD: updateCourse -- PARAMS: " + course);

        Course thisCourse = courseRepository.save(course);

        LOGGER.info("DATA RETURN: " + thisCourse);
        return thisCourse;
    }

    @Override
    public void removeCourse(Course course) {
        LOGGER.info("METHOD: removeCourse -- PARAMS: " + course);

        courseRepository.delete(course);
    }
}
