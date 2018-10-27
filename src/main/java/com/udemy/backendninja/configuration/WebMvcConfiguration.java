package com.udemy.backendninja.configuration;

import com.udemy.backendninja.component.RequestTimeInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    private static final Log LOGGER = LogFactory.getLog(WebMvcConfiguration.class);

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("METHOD: addInterceptors");

        registry.addInterceptor(interceptor);
    }
}
