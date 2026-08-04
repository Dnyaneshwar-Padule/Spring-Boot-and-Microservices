package com.tca;


import com.tca.beans.GreetBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application{

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext =  SpringApplication.run(Application.class, args);

        GreetBean g1 =  applicationContext.getBean(GreetBean.class);
        GreetBean g2 = applicationContext.getBean(GreetBean.class);

        System.out.println(g1 + " : " + g2);

        g1.greet();
        g2.greet();

    }

    /*

        Imp:
            If a dependent class has only one constructor and it's parameterized constructor containing it's dependency classes
            as parameters, then the Spring Container can automatically inject those dependencies without using
            @Autowired annotation, but those dependency classes should be Spring Beans (they should have @Component)

            ex.)
            Suppose WelcomeBean is a Spring Bean

            @Component
            class GreetBean{
                private WelcomeBean welcomeBean;  // No @Autowired

                // No Autowired here too.....
                public GreetBean(WelcomeBean welcomeBean){
                    this.welcomeBean = welcomeBean;
                }
            }



        Static:
            Static block is executed only once while class loading.
            All objects of a Class use the same static method/field (they are shared across all the objects)
            static method/field is a Class property.

        final:
            final fields are immutable once initialized during the object initialization/creation.
            they are different for each object (i.e. every object has it's own final field with unique value)
            they can be autowired with
                - Field Injection
                - Constructor Injection 
            setter injection can't be used for final as the object is already initialized....

     */
}