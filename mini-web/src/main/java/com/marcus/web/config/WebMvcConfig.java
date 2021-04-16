package com.marcus.web.config;

import com.marcus.web.annotation.suppert.UserAuthHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configurable
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserAuthHandlerMethodArgumentResolver());
    }
}
