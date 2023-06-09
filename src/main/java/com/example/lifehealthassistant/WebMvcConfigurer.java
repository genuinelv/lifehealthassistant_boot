package com.example.lifehealthassistant;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/pic_user/**").addResourceLocations("file:D:/pic_user/");
        registry.addResourceHandler("/pic_diet/**").addResourceLocations("file:D:/pic_diet/");
        registry.addResourceHandler("/pic_disease/**").addResourceLocations("file:D:/pic_disease/");
    }
}
