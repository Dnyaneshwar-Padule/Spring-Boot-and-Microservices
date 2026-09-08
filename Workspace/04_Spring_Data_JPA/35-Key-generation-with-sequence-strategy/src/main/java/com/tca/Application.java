package com.tca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        /*

        PostgreSQL and mariaDB both have inbuilt SEQUENCE, so it create sequence in both


        The Complete Flow
            Hibernate does not ask PostgreSQL for every individual entity ID. When its local identifier allocation is
            unavailable, it calls nextval('student_sequence'). The returned sequence value is treated as the
            inclusive upper bound for Hibernate's allocation. Hibernate then generates the identifiers locally within
            that allocation.

            On the very first startup, PostgreSQL returns 1. With allocation size 50, the arithmetic range associated
            with that upper bound would extend below the configured initial value. Since initialValue = 1, values
            below 1 are not usable, leaving only [1]. The first student therefore receives ID 1, and PostgreSQL reports
            last_value = 1.

            After the application terminates, Hibernate's in-memory allocation state is gone, but PostgreSQL keeps its
            sequence state. On the second startup, Hibernate calls nextval() again and PostgreSQL returns 51.
            The allocation size is 50, so the arithmetic lower boundary is 51 − 50 = 1. However, 1 is the previous
            upper-bound value and the upper bound is inclusive. Therefore the new usable range begins at 2 and
            ends at 51: [2 ... 51]. The first student saved in this new application instance receives ID 2. PostgreSQL
            now has last_value = 51.

            On the third startup, PostgreSQL returns 101. The arithmetic lower boundary is 101 − 50 = 51, but 51 is
            already the previous upper bound. Therefore the new usable range is [52 ... 101], and the first student
            receives ID 52. PostgreSQL now has last_value = 101.

            The same pattern continues. A PostgreSQL upper bound of 151 gives Hibernate the usable range [102 ...
            151], so the next application startup can generate ID 102.
            Hibernate State + PostgreSQL State
            Run / event           PostgreSQL sequence               Hibernate usable allocation         First ID used
            1st startup           nextval → 1,   last_value = 1                  [1]                          1
            2nd startup           nextval → 51,  last_value = 51              [2 ... 51]                      2
            3rd startup           nextval → 101, last_value = 101            [52 ... 101]                     52
            4th startup           nextval → 151, last_value = 151            [102 ... 151]                    102

         */
    }

}
