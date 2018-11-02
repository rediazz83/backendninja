package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseRepository;
import com.udemy.backendninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseConverter courseConverter;

    @Override
    public List<CourseModel> listAllCourses() {
        LOGGER.info("METHOD: listAllCourses");

        List<CourseModel> courseModelList = new ArrayList<>();
        List<Course> courses = courseRepository.findAll();
        for(Course entity: courses) {
            CourseModel model = courseConverter.entityToModel(entity);
            courseModelList.add(model);
        }

        LOGGER.info("DATA SIZE RETURN: " + courseModelList.size());
        return courseModelList;
    }

    @Override
    public CourseModel addCourse(CourseModel courseModel) {
        LOGGER.info("METHOD: addCourse -- PARAMS: " + courseModel);

        Course entity = courseRepository.save(courseConverter.modelToEntity(courseModel));
        CourseModel newCourseModel = courseConverter.entityToModel(entity);

        LOGGER.info("DATA RETURN: " + newCourseModel);
        return newCourseModel;
    }

    @Override
    public CourseModel updateCourse(CourseModel courseModel) {
        LOGGER.info("METHOD: updateCourse -- PARAMS: " + courseModel);

        Course entity = courseRepository.save(courseConverter.modelToEntity(courseModel));
        CourseModel newCourseModel = courseConverter.entityToModel(entity);

        LOGGER.info("DATA RETURN: " + newCourseModel);
        return newCourseModel;
    }

    @Override
    public void removeCourse(CourseModel courseModel) {
        LOGGER.info("METHOD: removeCourse -- PARAMS: " + courseModel);

        courseRepository.delete(courseConverter.modelToEntity(courseModel));
    }
}
