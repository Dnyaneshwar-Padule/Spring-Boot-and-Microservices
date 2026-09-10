package com.tca.model;

import lombok.*;

//@RequiredArgsConstructor
//@Getter
//@Setter
@EqualsAndHashCode
@Data
public class Student {
    private int rno;
    private String name;
    private double per;
    private String city;

    @Setter
    @Getter
    private static int count;

}
