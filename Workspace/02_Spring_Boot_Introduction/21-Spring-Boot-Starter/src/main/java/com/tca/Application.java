package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
    @SpringBootApplication is a combination of 3 annotations
    1. Configuration
    2. ComponentScan
    3. EnableAutoConfiguration

    1. Configuration
    -----------------
    AS we know this annotation tells that the following class is a Configuration class
    used by the container to create beans with configuration....
    The container needs a Configuration class to start.

    2. ComponentScan
    It scans the packages beginning from the package containing the Application class.
    The ComponentScan annotation is used to create beans by scanning the classes in project
    It creates the beans of classes if the class has stereotype annotation (Service, Controller, Repository, Component etc)

    3. EnableAutoConfiguration
    This annotation enables autoconfiguration for out Spring boot project.
    It scans the classpath and sees for dependencies to auto-configure...

 */
public class Application {

    public static void main(String[] args) {

        /*
            SpringApplication.run() method starts our project
            It does 3 tasks

            1. Starts the container
            2. Loads the configurations
            3. Starts the required components

            1. Starts the container
            ------------------------
            Spring Boot uses the Application class as the primary configuration source. From this class, it discovers component-scanned beans, @Bean methods, and auto-configuration.
            here the Application class is Configuration class...
            (since the SpringBootApplication contains Configuration annotation), so we have passed the Application.class as the first
            parameter for the run method.

            2. Loads the Configurations
            If we want to change some configuration info at the runtime,
            like changing server.port from 8080 (default) to 8081, we have to pass it as the command line argument,
            it will then be overwritten to the existing property
            to pass it as the command line argument use two hypens (--) before the property
            ex. @] java -jar application.jar --server.port=8081

            3. Starts the required components
            like Server
         */
        SpringApplication.run(Application.class, args);
    }

}
