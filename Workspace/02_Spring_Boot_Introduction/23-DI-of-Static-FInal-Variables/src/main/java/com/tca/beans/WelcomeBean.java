package com.tca.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WelcomeBean {

    private static  int cnt;
    private int id;

    static {
        cnt = 0;
    }

    public WelcomeBean(){
        id = ++cnt;
        System.out.println("Welcome Bean created with ID : " + id);
    }

    public void sayWelcome(){
        System.out.println("Welcome from " + id);
    }
}
