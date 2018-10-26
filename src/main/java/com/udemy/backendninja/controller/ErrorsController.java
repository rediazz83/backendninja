package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

    private static final Log LOGGER = LogFactory.getLog(ErrorsController.class);
    private static final String INTERNAL_SERVER_ERROR_VIEW = "errror/500";

    @ExceptionHandler(Exception.class)
    public String showInternalServerError() {
        LOGGER.info("METHOD: showInternalServerError -- TEMPLATE: " + INTERNAL_SERVER_ERROR_VIEW);
        return INTERNAL_SERVER_ERROR_VIEW;
    }

}
