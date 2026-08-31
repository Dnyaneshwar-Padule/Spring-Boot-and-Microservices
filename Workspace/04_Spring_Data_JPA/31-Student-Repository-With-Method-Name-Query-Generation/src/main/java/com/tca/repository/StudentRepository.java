package com.tca.repository;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/*
       Query generation from method name
       syntax.
            <find/get/read> + By + PropertyName

            ex.) findByBirthDate(LocalDate birthDate);
 */

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Optional<Student> findById(Integer id);

    public List<Student> findByName(String name);

    public List<Student> findByGender(Gender gender);

    public List<Student> findByCity(String city);

    public List<Student> findByPer(Double per);

    public List<Student> findByBirthDate(LocalDate birthDate);

    /* AND Comparison */

    public List<Student> findByNameAndCity(String name, String city);

    public List<Student> findByNameAndPer(String name, Double per);

    public List<Student> findByNameAndBirthDate(String name, LocalDate birthDate);

    public List<Student> findByGenderAndCity(Gender gender, String city);

    public List<Student> findByGenderAndBirthDate(Gender gender, LocalDate birthDate);

    public List<Student> findByGenderAndPer(Gender gender, Double per);

    public List<Student> findByCityAndPer(String city, Double per);

    /* OR Comparison */

    public List<Student> findByCityOrName(String city, String Name);

    public List<Student> findByNameOrBirthDate(String name, LocalDate birthDate);

    public List<Student> findByGenderOrPer(Gender gender, Double per);

    /* Greater than */

    public List<Student> findByBirthDateGreaterThan(LocalDate localDate);

    public List<Student> findByPerGreaterThan(Double per);

    /* Less than */

    public List<Student> findByPerLessThan(Double per);

    public List<Student> findByBirthDateLessThan(LocalDate birthDate);

    /* Less than equal to */

    public List<Student> findByPerLessThanEqual(Double per);

    public List<Student> findByBirthDateLessThanEqual(LocalDate birthDate);

    /* Greater Than Equal to */

    public List<Student> findByPerGreaterThanEqual(Double per);

    public List<Student> findByBirthDateGreaterThanEqual(LocalDate birthDate);

    /* Range / Between */
    /* start and are inclusive */

    public List<Student> findByPerBetween(
            Double startPer,
            Double endPer
    );
    /* SELECT * FROM STUDENT WHERE PER BETWEEN startPer and endPer */
    /* SELECT * FROM STUDENT WHERE PER <= startPer AND per <= endPer */

    public List<Student> findByBirthDateBetween(
            LocalDate from,
            LocalDate to
    );


    /* LIKE */

    public List<Student> findByCityLike(String city);
    /* SELECT * FROM STUDENT WHERE CITY LIKE city */

    public List<Student> findByNameLike(String name);
    /* SELCT * FROM STUDENT WHERE NAME LIKE name */


    /* Containing */

    public List<Student> findByNameContaining(String name);
    /* SELECT * FROM STUDENT WHERE NAME LIKE '%name%' */

    public List<Student> findByCityContaining(String city);


    /* startingWith */

    public List<Student> findByCityStartingWith(String cityPrefix);
    // SELECT * FROM STUDENT WHERE CITY LIKE 'cityPrefix%'

    public List<Student> findByNameStartingWith(String namePrefix);
    // SELECT * FROM STUDENT WHERE NAME LIKE 'namePrefix%'


    /* endingWith */

    public List<Student> findByCityEndingWith(String citySuffix);
    // SELECT * FROM STUDENT WHERE NAME LIKE '%citySuffix'

    public List<Student> findByNameEndingWith(String nameSuffix);


    /* IgnoreCase */

    public List<Student> findByNameIgnoreCase(String name);
    // SELECT * FROM STUDENT WHERE NAME LIKE '%name%'
    // It compares name with ignoring case sensitivity....

    public List<Student> findByCityIgnoreCase(String city);


    /* NOT */

    public List<Student> findByNameNot(String name);
    // SELECT * FROM STUDENT WHERE NAME <> name
    // NAME not equal to name (given name)

    public List<Student> findByCityNot(String city);

    /* IS NULL */

    public List<Student> findByPerIsNull();
    // SELECT * FROM STUDENT WHERE PER IS NULL;

    public List<Student> findByBirthDateIsNull();
    // SELECT * FROM STUDENT WHERE BIRTH_DATE IS NULL;


    /* IS NOT NULL */

    public List<Student> findByPerIsNotNull();
    //SELECT * FROM STUDENT WHERE PER IS NOT NULL;


    /* TRUE / FALSE */
    // private boolean active;
    //public List<Student> findByActiveTrue();

    /* Different Combinations.... */

//    Find students whose percentage is greater than 75 and who live in Pune.
    public List<Student> findByPerGreaterThanAndCityLike(
            Double per,
            String city
    );

//    Find students whose name contains "raj", ignoring case, and who live in Mumbai.
    public List<Student> findByNameContainsIgnoreCaseAndCityLike(
            String name,
            String city
    );

//    Find students whose percentage is less than 40 OR whose city is "Pune".
    public List<Student> findByPerLessThanOrCityLike(
            Double per,
            String city
    );

//    Find students whose name starts with "A", ignoring case, AND whose percentage is greater than or equal to 70.
    public List<Student> findByNameStartingWithIgnoreCaseAndPerGreaterThanEqual(
            String namePrefix,
            Double per
    );

//    Find students whose percentage is greater than 80, whose gender is FEMALE, and who live in Pune.
    public List<Student> findByPerGreaterThanAndGenderAndCityLike(
            Double per,
            Gender gender,
            String city
    );

//    Find students whose city is not Mumbai AND whose percentage is between 50 and 75.
    public List<Student> findByCityNotLikeAndPerBetween(
            String city,
            Double perStart,
            Double perEnd
    );

//    Find students whose name contains "an", ignoring case, AND whose gender is MALE OR whose percentage is greater than 90.
    public List<Student> findByNameContainsIgnoreCaseAndGenderOrPerGreaterThan(
            String namePrefix,
            Gender gender,
            Double per
    );

//    Find students whose name ends with "sh", ignoring case, AND whose city is Pune or Mumbai.
    public List<Student> findByNameEndingWithIgnoreCaseAndCityIn(
            String nameSuffix,
            List<String> cities
    );

//    Find students whose percentage is less than 35 OR greater than 85, AND whose gender is FEMALE.
    public List<Student> findByPerLessThanOrPerGreaterThanAndGender(
            Double perLow,
            Double perHigh,
            Gender gender
    );


//    Find students born after 1 January 2005.
    public List<Student> findByBirthDateAfter(LocalDate birthDate);

//    Find students born before 1 January 2000 AND whose percentage is greater than 70.
    public List<Student> findByBirthDateBeforeAndPerGreaterThan(
            LocalDate birthDate,
            Double per
    );

//    public List<Student> findByBirthDateBetween(LocalDate from, LocalDate to);
//    Find students born between 1 January 2002 and 31 December 2005.

//    Find students born after 1 January 2005, whose gender is MALE, and whose city is Pune.
    public List<Student> findByBirthDateAfterAndGenderAndCityLike(
            LocalDate birthDate,
            Gender gender,
            String city
    );

//    Find students born before 2000 OR after 2005, and whose percentage is greater than or equal to 60.
    public List<Student> findByBirthDateBeforeOrBirthDateAfterAndPerGreaterThanEqual(
            LocalDate before,
            LocalDate after,
            Double per
    );


}
