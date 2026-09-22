package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double percentage;

    /* we can calculate grade from percentage, i.e. we don't really need to store the grade in the database */
    /* if we don't want to map a field to column, we need to use  @Transient

        * And if table has more columns and our entity has less column, it can work
        but that extra column in the table should not have not null constraint.

     */
    @Transient
    private String grade;

    public String getGrade(){
        if(percentage.compareTo(90.0) >= 0 )
            return "A";
        if(percentage.compareTo(80.0) >= 0)
            return "B";
        if(percentage.compareTo(70.0) >= 0)
            return "C";
        if(percentage.compareTo(60.0) >= 0)
            return "D";
        if(percentage.compareTo(40.0) >= 0)
            return "E";
        else
            return "F";
    }
}
