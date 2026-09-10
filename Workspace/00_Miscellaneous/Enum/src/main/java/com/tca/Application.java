package com.tca;

import constants.Gender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        Gender g = Gender.MALE;
        Gender g1 = Gender.FEMALE;

        System.out.println(g + " " + g1);
    }

    /*

        - enums are used when we want to declare constants
        - enums are special type of classes
        - to declare enum we use enum keyword with enumName
        - to declare constants write them inside enum separated them with a comma

        - every enum is a class who by default extends Enum class
        - Enum class has 2 instance variables, String name and int ordinal

        - when we write a constant inside a enum
        for ex.)
            enum Gender{
                MALE,
                FEMALE
            }

            those constants are actually instance variables of class Gender
            you can imagine it like

            class Gender extends Enum<Gender>{
                public static final Gender MALE = new MALE("MALE", 1);
                public static final Gender FEMALE = new FEMALE("FEMALE", 2);
            }

            since they are static we can access them with only class name, and since they are final, their reference can't be changed.

            If we want extra info for our constants we can add them too
            like this

            public enum Gender {
                MALE("M"),
                FEMALE("F");

                private String name;

                private Gender(String name){
                    this.name = name;
                }

                public String getName(){
                    return name;
                }
            }

            the MALE("M") internally calls our constructor, and initializes name
            internally they also call the super("", 0) constructor.

            the constructor is private so, nobody will create another object of it
            (another object means another possible value for Gender)
            ex.)
               Gender other = new Gender("Other");
               Now other can also be a Gender, but we only want male and female values no less no more....

     */

}
