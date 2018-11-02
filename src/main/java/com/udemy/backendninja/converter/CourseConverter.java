package com.udemy.backendninja.converter;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

    private static final Log LOGGER = LogFactory.getLog(CourseConverter.class);

    public CourseModel entityToModel(Course entity) {
        LOGGER.info("METHOD: entityToModel -- PARAMS: " + entity);

        CourseModel model = new CourseModel(entity.getName(), entity.getDescription(),
                entity.getPrice(), entity.getHours());

        LOGGER.info("DATA RETURN: " + model);
        return model;
    }

    public Course modelToEntity(CourseModel model) {
        LOGGER.info("METHOD: modelToEntity -- PARAMS: " + model);

        Course entity = new Course(model.getName(), model.getDescription(),
                model.getPrice(), model.getHours());

        LOGGER.info("DATA RETURN: " + entity);
        return entity;
    }
}
