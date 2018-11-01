package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> listAllCourses();

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void removeCourse(Course course);
}
