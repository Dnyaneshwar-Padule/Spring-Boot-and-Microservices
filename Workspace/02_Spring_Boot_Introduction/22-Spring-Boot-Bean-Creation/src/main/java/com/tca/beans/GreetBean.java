package com.tca.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetBean {

    @Autowired
    private WelcomeBean welcomeBean;

    public GreetBean(){
        System.out.println("GreetBean Crated !");
    }

//    @Autowired
    public GreetBean(WelcomeBean welcomeBean){
        this.welcomeBean = welcomeBean;
        System.out.println("GreetBean created with parameterized constructor !!");
    }

//    @Autowired
    public void setWelcomeBean(WelcomeBean welcomeBean){
        this.welcomeBean = welcomeBean;
    }
}
