package com.tca.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@ComponentScan(basePackages="com.tca")

@PropertySource("application.properties")
public class AppConfig {

}
