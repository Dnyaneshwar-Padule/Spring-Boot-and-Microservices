package com.tca;

import com.tca.beans.Sample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
        System.out.println("Container name : " + context.getClass().getName());

        context.close();
    }
    /*
        In Spring Boot beans are crated in alphabetical order of their class Name,
        if a bean uses constructor autowiring then the dependency beans will be created before the dependent bean.
     */

    @Bean
    public Sample getSample() {
        System.out.println("Bean method called for creating bean of Sample !");
        return new Sample();
    }

}
