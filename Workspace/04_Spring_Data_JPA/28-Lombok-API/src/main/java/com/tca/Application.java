package com.tca;

import com.tca.model.CollegeStudent;
import com.tca.model.Student;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);


        Student s = new Student();
        s.setRno(1);
        s.setName("Amit");
        s.setPer(80);
        s.setCity("Pune");

        /*

            // To check equals() method

            CollegeStudent c = new CollegeStudent();
            c.setRno(1);
            c.setName("Amit");
            c.setPer(80);
            c.setCity("Pune");
            c.setCollege("NMIET");

            System.out.println(s instanceof Student);          // true
            System.out.println(c instanceof Student);          // true
            System.out.println(c instanceof CollegeStudent);   // true
            System.out.println((s instanceof CollegeStudent)); // false
            System.out.println(s.equals(c));                   // false
            System.out.println(c.equals(s));                   // false
         */

    }



    /*
        @Setter:
            - It can be used on Class or an individual fields
            - It can be used with static fields, but (Obviously) not with final fields.

        @Getter:
            - It can be used on Class or individual fields
            - It can be used with static and final fields.

        @RequiredArgsConstructor:
            - It creates a parameterized constructor including,
                NON-STATIC, NON-INITIALIZED FINAL fields as well as
                fields annotated with @NonNull.

        @AllArgsConstructor:
            - It generates a parameterized constructor including all Non-Static fields.

        @NonNull:
            - Can be useful for simple fields which needs to be initialized.
            - Works with @RequiredArgsConstructor

        @EqualsAndHashCode:
            - generates equals() and hashCode() method

        @Data:
            - @Data is a convenient shortcut annotation that bundles the features of
                @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

}
