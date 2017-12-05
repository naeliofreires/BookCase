package com.bookcase.configuration;

import com.bookcase.interceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private Interceptor interceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor);
    }
}

