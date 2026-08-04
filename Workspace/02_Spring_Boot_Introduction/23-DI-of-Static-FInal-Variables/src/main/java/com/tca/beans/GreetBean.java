package com.tca.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class GreetBean {

//    @Autowired
    private static WelcomeBean welcomeBean;

    public GreetBean(){
//        welcomeBean = null;
        System.out.println("GreetBean created !");
    }

    @Autowired
    public GreetBean(WelcomeBean welcomeBean) {
//        GreetBean.welcomeBean = welcomeBean;
            this.welcomeBean = welcomeBean;
    }

    public void greet(){
        System.out.println("Hello !");
        welcomeBean.sayWelcome();
    }

}
