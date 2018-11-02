package com.udemy.backendninja.service;

import com.udemy.backendninja.model.CourseModel;

import java.util.List;

public interface CourseService {

    List<CourseModel> listAllCourses();

    CourseModel addCourse(CourseModel course);

    CourseModel updateCourse(CourseModel course);

    void removeCourse(CourseModel course);
}
