package com.hzm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : hzm
 * @date : 2020-03-02 23:22
 */
@Configuration
@ComponentScan("com.*")
public class AppConfig implements WebMvcConfigurer {

}
