package com.hzm.init.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : hzm
 * @date : 2020-02-29 23:20
 */
@Configuration
@ComponentScan("com.hzm.*")
@EnableAspectJAutoProxy
public class AppConfig {

}
