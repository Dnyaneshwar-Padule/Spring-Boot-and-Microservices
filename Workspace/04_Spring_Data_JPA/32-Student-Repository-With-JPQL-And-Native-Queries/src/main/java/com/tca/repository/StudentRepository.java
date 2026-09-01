package com.tca.repository;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    /*
        There are two ways to pass parameters to queries
            1. Positional Parameters
                ex.) ?1, ?2...

            2. Named Parameter
               - we use : before the parameter name in query

               ex.) method parameter is String name
               so we will write :name inside query

               we can also use @Param("")
               ex. method parameter is String name
               so we will give it a name as we want like before the parameter
               like, @Param("studentName") String name
               and then use that parameter name inside query with :
               like :studentName


            1. @Modifying
                Marks the repository method as a data-modifying operation (INSERT, UPDATE, DELETE).
                Without this, Spring Data JPA treats @Query methods as read-only SELECT queries and rejects any DML attempt at runtime.

            2. @Transactional
                wraps the method execution in a database transaction.
                Hibernate requires a transaction context for any INSERT, UPDATE, or DELETE operation

     */

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.per < :per AND s.city = :city ")
    public void deleteByPerSmallerThanAndCity(@Param("per") Double per, @Param("city") String city );



    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.per = :newPer WHERE s.city = :city AND s.gender = :gender ")
    public void updatePerByGenderAndCity(@Param("newPer") Double newPer, @Param("gender") Gender gender, @Param("city") String city);






    /* Find all students whose percentage is greater than 75. */
    @Query("SELECT s FROM Student s WHERE s.per > :per")    // JPQL
    public List<Student> fetchByPerGreaterThan(Double per);

    @Query(name = "SELECT * FROM STUDENT WHERE PER > :per", nativeQuery = true) // NATIVE SQL
    public List<Student> getByPerGreaterThan(Double per);

    /* Find the student whose id is 101. */
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    public Optional<Student> fetchById(@Param("id") Integer id);

    @Query(value="SELECT * FROM STUDENT WHERE ID = :id", nativeQuery = true)
    public Optional<Student> getByID(@Param("id") Integer id);


    /* Find all students who live in Pune. */
    @Query("SELECT s FROM Student s WHERE s.city LIKE :city")
    public List<Student> fetchByCity(@Param("city") String city);

    @Query(value="SELECT * FROM STUDENT WHERE CITY LIKE :city", nativeQuery = true)
    public List<Student> getByCity(@Param("city") String city);


    /* Find all female students. */
    @Query("SELECT s FROM Student s WHERE s.gender = :gender")
    public List<Student> fetchByGender(Gender gender);

    @Query(value="SELECT * FROM STUDENT WHERE GENDER = :gender", nativeQuery = true)
    public List<Student> getByGender(@Param("gender") Gender gender);


    /* Find all students whose percentage is between 60 and 80, inclusive. */
    @Query("SELECT s FROM Student s WHERE s.per BETWEEN :from AND :to")
    public List<Student> fetchByPerBetween(
            @Param("from") Double fromPer,
            @Param("to") Double toPer
    );

    @Query(value="SELECT * FROM STUDENT WHERE PER BETWEEN :from AND :to", nativeQuery = true)
    public List<Student> getByPerBetween(
            @Param("from") Double fromPer,
            @Param("to") Double toPer
    );


    /* Find students who live in Pune and have percentage greater than 75. */
    @Query("SELECT s FROM Student s WHERE s.city LIKE :city AND s.per > :per")
    public List<Student> fetchByCityAndPerGreaterThan(
            @Param("city") String city,
            @Param("per") Double per
    );

    @Query(value="SELECT * FROM STUDENT WHERE CITY LIKE :city AND PER > :per", nativeQuery = true)
    public List<Student> getByCityAndPerGreaterThan(
            @Param("city") String city,
            @Param("per") Double per
    );


    /* Find students who live in Pune or Mumbai. */
    @Query("SELECT s FROM Student s WHERE s.city IN :cities")
    public List<Student> fetchByCities(@Param("cities") List<String> cities);

    @Query(name = "SELECT * FROM STUDENT WHERE CITY IN :cities", nativeQuery = true)
    public List<Student> getByCities(@Param("cities") List<String> cities);


    /* Find male students whose percentage is at least 70. */
    @Query("SELECT s FROM Student s WHERE s.gender = :gender AND s.per >= :per")
    public List<Student> fetchByGenderAndPerGreaterThanEqual(
            @Param("gender") Gender gender,
            @Param("per") Double per
    );

    @Query(value="SELECT * FROM STUDENT WHERE GENDER = :gender AND PER >= :per", nativeQuery = true)
    public List<Student> getByGenderAndPerGreaterThanEqual(
            @Param("gender") Gender gender,
            @Param("per") Double per
    );


    /* Find students whose name starts with "A". */
    @Query("SELECT s FROM Student s WHERE s.name LIKE CONCAT(:namePrefix, '%') ")
    public List<Student> fetchByNameStartingWith(@Param("namePrefix") String namePrefix);

    @Query( value="SELECT * FROM STUDENT WHERE NAME LIKE CONCAT(:namePrefix, '%')", nativeQuery = true)          // I am using mariadb so it will work for now !!
    public List<Student> getByNameStartingWith(@Param("namePrefix") String namePrefix);


    /* Find students whose name contains "raj", ignoring case. */
    @Query("SELECT s FROM Student s WHERE lower(s.name) LIKE concat(lower(:name),'%') ")
    public List<Student> findByNameStartingWithIgnoreCase(@Param("name") String name);

    @Query(name = "SELECT * FROM STUDENT WHERE LOWER(NAME) LIKE CONCAT(LOWER(:name), '%') ", nativeQuery = true)
    public List<Student> getByNameStartingWithIgnoreCase(@Param("name") String name);


    /* Find students whose birth date is before a supplied date. */
    @Query("SELECT s FROM Student s WHERE s.birthDate < :birthDate")
    public List<Student> fetchByBirthDateBefore(@Param("birthDate") LocalDate birthDate);

    @Query(name = "SELECT * FROM STUDENT WHERE BIRTH_DATE < :birthDate", nativeQuery = true)
    public List<Student> getByBirthDateBefore(@Param("birthDate") LocalDate birthDate);


    /* Find students whose birth date lies between two supplied dates. */
    @Query("SELECT s FROM Student s WHERE s.birthDate BETWEEN :from AND :to")
    public List<Student> fetchByBirthDateBetween(
            @Param("from") LocalDate fromBirthDate,
            @Param("to") LocalDate toBirthDate
    );

    @Query(value="SELECT * FROM STUDENT WHERE BIRTH_DATE BETWEEN :from and :to", nativeQuery = true)
    public List<Student> getByBirthDateBetween(
            @Param("from") LocalDate fromBirthDate,
            @Param("to") LocalDate toBirthDate
    );


    /* Find students whose name contains a supplied search string, ignoring case. */
    @Query("SELECT s FROM Student s WHERE lower(s.name) LIKE CONCAT('%', concat(:name ,'%') ) ")
    public List<Student> fetchByNameContainingIgnoreCase(@Param("name") String name);

    @Query(value="SELECT * FROM STUDENT WHERE LOWER(NAME) LIKE CONCAT('%', CONCAT(:name, '%'))", nativeQuery = true)
    public List<Student> getByNameContainingIgnoreCase(@Param("name") String name);


    /* Find students whose gender belongs to a supplied collection of genders. */
    @Query("SELECT s FROM Student s WHERE s.gender IN :genders")
    public List<Student> fetchByGenderIn(@Param("genders") List<Gender> genders);

    @Query(name = "SELECT * FROM STUDENT WHERE GENDER IN :genders", nativeQuery = true)
    public List<Student> getByGenderIn(@Param("genders") List<Gender> genders);


    /*  Find students whose ID belongs to a supplied collection of IDs and whose percentage is greater than 70. */
    @Query("SELECT s FROM Student s WHERE s.id IN :ids and s.per > :per")
    public List<Student> fetchByIdInAndPerGreaterThan(
            @Param("ids") List<Integer> ids,
            @Param("per") Double per
    );

    @Query(value="SELECT * FROM STUDENTS WHERE ID IN :ids AND PER > :per",nativeQuery = true)
    public List<Student> getByIdInAndPerGreaterThan(
            @Param("ids") List<Integer> ids,
            @Param("per") Double per
    );

    /*    Find students whose city is not among given cities  */
    @Query("SELECT s FROM Student s WHERE s.city NOT IN :cities")
    public List<Student> fetchByCityNotIn(@Param("cities") List<String> cities);

    @Query(value="SELECT * FROM STUDENT WHERE CITY NOT IN :cities", nativeQuery = true)
    public List<Student> getByCityNotIn(@Param("cities") List<String> cities);

    /* Find students whose city is NULL. */
    @Query("SELECT s FROM Student s WHERE s.city IS NULl")
    public List<Student> fetchByCityIsNull();

    @Query(value="SELECT * FROM STUDENT WHERE CITY IS NULL", nativeQuery = true)
    public List<Student> getByCityIsNull();


    /* Find students whose city is not NULL. */
    @Query("SELECT s FROM Student s WHERE s.city IS NOT NULl")
    public List<Student> fetchByCityIsNotNull();

    @Query(value="SELECT * FROM STUDENT WHERE CITY IS NOT NULL", nativeQuery = true)
    public List<Student> getByCityIsNotNull();


    /* Find students whose name is not NULL and percentage is greater than 60. */
    @Query("SELECT s FROM Student s WHERE s.city IS NOT NULL AND s.per > :per")
    public List<Student> fetchByCityNotNullAndPerGreaterThan(@Param("per") Double per);

    @Query(name = "SELECT * FROM STUDENT WHERE CITY IS NOT NULL AND PER > :per", nativeQuery = true)
    public List<Student> getByCityNotNullAndPerGreaterThan(@Param("per") Double per);


    /* Find the average percentage of all students. */
    @Query("SELECT AVG(s.per) FROM Student s")
    public Double fetchAveragePer();

    @Query( name = "SELECT AVG(PER) FROM STUDENT", nativeQuery = true)
    public Double getAveragePer();


    /* Find the highest percentage. */
    @Query("SELECT MAX(s.per) FROM Student s")
    public Double fetchMaxPer();

    @Query(value="SELECT MAX(PER) FROM STUDENT", nativeQuery = true)
    public Double getMaxPer();

    /* Find the lowest percentage. */
    @Query("SELECT MIN(s.per) FROM Student s")
    public Double fetchMinPer();

    @Query(value="SELECT MIN(PER) FROM STUDENT", nativeQuery = true)
    public Double getMinPer();


    /* Find the number of students. */
    @Query("SELECT COUNT(s) FROM Student s")
    public Long fetchCount();

    @Query(name = "SELECT COUNT(*) FROM STUDENT", nativeQuery = true)
    public Long getCount();


    /* Find the number of students living in Pune. */
    @Query("SELECT COUNT(s) FROM Student  s WHERE s.city LIKE :city" )
    public Long fetchCountByCity(@Param("city") String city);

    @Query(name = "SELECT COUNT(*) FROM STUDENT WHERE CITY LIKE :city ", nativeQuery = true)
    public Long getCountByCity(@Param("city") String city);


    /* Find the average percentage of male students. */
    @Query("SELECT AVG(s.per) FROM Student  s WHERE s.gender = :gender")
    public Double fetchAveragePerByGender(@Param("gender") Gender gender);

    @Query(name = "SELECT AVG(PER) FROM STUDENT  WHERE GENDER = :gender", nativeQuery = true)
    public Double getAveragePerByGender(@Param("gender") Gender gender);


    /* Find the number of students in each city
    Expected conceptual result:
    Pune      → 15
    Mumbai    → 23
    Delhi     → 8
    */
    @Query("SELECT s.city, COUNT(s) FROM Student s GROUP BY s.city")
    public List<Object[]> fetchStudentCountInEachCity();

    @Query(value="SELECT CITY, COUNT(*) FROM STUDENT GROUP BY CITY", nativeQuery = true)
    public List<Object[]> getStudentCountInEachCity();

    /* Find the average percentage for each city. */
   @Query("SELECT s.city, AVG(s.per) FROM Student s GROUP BY s.city")
    public List<Object[]> fetchAveragePerWithCity();

    @Query(value="SELECT CITY, AVG(PER) FROM STUDENT GROUP BY CITY", nativeQuery = true)
    public List<Object[]> getAveragePerWithCity();

    /* Find the number of male and female students separately*/
    @Query("SELECT s.gender, COUNT(s) FROM Student s GROUP BY s.gender")
    public List<Object[]> fetchCountByGender();

    @Query(value="SELECT GENDER, COUNT(*) FROM STUDENT GROUP BY GENDER", nativeQuery = true)
    public List<Object[]> getCountByGender();


    /* Find the highest percentage in each city.*/
    @Query("SELECT s.city, MAX(s.per) FROM Student s GROUP BY s.city")
    public List<Object[]> fetchMaxPerWithEachCity();

    @Query(name = "SELECT CITY, MAX(PER) FROM STUDENT GROUP BY CITY", nativeQuery = true)
    public List<Object[]> getMaxPerWithEachCity();


    /* Find cities having more than 10 students.*/
    @Query("SELECT s.city FROM Student s GROUP BY s.city HAVING COUNT(s) > :count")
    public List<String> fetchCitiesWithStudentCount(@Param("count") Integer requiredStudentCount);

    @Query(value="SELECT CITY FROM STUDENT GROUP BY CITY HAVING COUNT(*) > :count", nativeQuery = true)
    public List<String> getCitiesWithStudentCount(@Param("count") Integer requiredStudentCount);


    /* Find cities whose average student percentage is greater than 70.*/
    @Query("SELECT s.city FROM Student s GROUP BY s.city HAVING AVG(s.per) > :per")
    public List<String> fetchCitiesWithAvgPerGreaterThan(@Param("per") Double per);

    @Query(value="SELECT CITY FROM STUDENT GROUP BY CITY HAVING AVG(PER) > :per", nativeQuery = true)
    public List<String> getCitiesWithAvgPerGreaterThan(@Param("per") Double per);


    /* Find genders having more than 20 students.*/
    @Query("SELECT s.gender FROM Student s GROUP BY s.gender HAVING COUNT(s) > :count")
    public List<Gender> fetchGenderWithCountGreaterThan(@Param("count") Integer count);

    @Query(value="SELECT GENDER FROM STUDENT GROUP BY GENDER HAVING COUNT(*) > :count", nativeQuery = true)
    public List<Gender> getGenderWithCountGreaterThan(@Param("count") Integer count);


    /*    Find students whose percentage is greater than the average percentage of all students. */
    @Query("SELECT s FROM Student s WHERE s.per > (SELECT AVG(s1.per) FROM Student s1 ) ")
    public List<Student> fetchByPerGreaterThanAvgPer();

    @Query(value="SELECT * FROM STUDENT WHERE PER > (SELECT AVG(PER) FROM STUDENT)", nativeQuery = true)
    public List<Student> getByPerGreaterThanAvgPer();


    /*  Find students whose percentage is equal to the highest percentage in the college. */
    @Query("SELECT s FROM Student s WHERE s.per = (SELECT MAX(s1.per) FROM Student s1)")
    public List<Student> fetchByPerEqualMaxPer();

    @Query(value="SELECT * FROM STUDENT WHERE PER = (SELECT MAX(PER) FROM STUDENT)", nativeQuery = true)
    public List<Student> getByPerEqualMaxPer();


    /* Find students who live in a city whose average percentage is greater than 75. */
    @Query("SELECT s FROM Student s WHERE s.city IN (SELECT s1.city FROM Student s1 GROUP BY s1.city HAVING AVG(s1.per) > :avgPer)")
    public List<Student> fetchByCityWithAvgPerGreaterThan(@Param("avgPer") Double avgPer);

    @Query(value="SELECT * FROM STUDENT WHERE CITY IN (SELECT CITY FROM STUDENT GROUP BY CITY HAVING AVG(PER) > :avgPer)", nativeQuery = true)
    public List<Student> getByCityWithAvgPerGreaterThan(@Param("avgPer") Double avgPer);

    /*    Find students whose percentage is greater than the average percentage of students from their own city.
        101 AAA 90 Pune
        102 BBB 80 Mumbai
        103 CCC 85 Mumbai
        104 DDD 70 Panji
        105 EEE 85 Pune
        106 FFF 95 Pune

        Pune    90
        Mumbai  80
        Panji   70

        select s1.id, s1.name, s1.per, s1.city, s1.birth_date
        from student s1
        join (
            select city, avg(per) as avg_per
            from student
            group by city
        ) as s2
        on s1.city = s2.city
        where s1.per > s2.avg_per;
     */
    @Query("SELECT s FROM Student s WHERE s.per > (SELECT AVG(s2.per) FROM Student s2 WHERE s2.city = s.city)")
    public List<Student> fetchByPerGreaterThanAvgPerOfSameCity();

    @Query(value="SELECT s1.ID, s1.NAME, s1.PER, s1.CITY, s1.GENDER, s1.BIRTH_DATE " +
            "FROM STUDENT s1 " +
            "JOIN " +
            "   (SELECT city, AVG(PER) as avg_per FROM STUDENT GROUP BY CITY) s2 " +
            "ON s1.city = s2.city " +
            "WHERE s1.per > s2.avg_per",
            nativeQuery = true
    )
    public List<Student> getByPerGreaterThanAvgPerOfSameCity();

    /* Find the student(s) having the second-highest percentage. */
    @Query("SELECT s " +
            "FROM Student s " +
            "WHERE s.per = (" +
            "   SELECT MAX(s2.per) " +
            "   FROM Student s2 " +
            "   WHERE s2.per != (" +
            "       SELECT MAX(s3.per) " +
            "       FROM Student s3" +
            "   )" +
            ") ")
    public List<Student> fetchSecondHighestStudents();

    @Query(value="SELECT * FROM STUDENT WHERE PER = " +
            "   (SELECT MAX(PER) FROM STUDENT WHERE PER != " +
            "       (SELECT MAX(PER) FROM STUDENT) " +
            "   )",
            nativeQuery = true
    )
    public List<Student> getSecondHighestStudents();


    /*
    Find students whose percentage is greater than the average percentage of students living in their own city,
    but only consider cities having at least 5 students.

        select s1.id, s1.name, s1.per, s1.city, s1.birth_date
        from student s1
        join (
            select city, avg(per) as avg_per, count(*) as count
            from student
            group by city
        ) as s2
        on s1.city = s2.city
        where s1.per > s2.avg_per
        and count >= studentCount;

     */
    @Query("SELECT s FROM Student s WHERE s.per > (SELECT AVG(s2.per) FROM Student s2 WHERE s2.city = s.city AND s2.city IN (SELECT s3.city FROM Student s3 GROUP BY s3.city HAVING COUNT(s3) >= :studentCount))")
    public List<Student> fetchByPerGreaterThanAvgPerOfSameCityHavingStudentCountGreaterThanEqual(@Param("studentCount") Integer studentCount);

    @Query(value="SELECT s1.ID, s1.NAME, s1.PER, s1.CITY, s1.GENDER, s1.BIRTH_DATE " +
            "FROM STUDENT s1 " +
            "JOIN " +
            "   (SELECT city, AVG(PER) as avg_per, COUNT(*) as count FROM STUDENT GROUP BY CITY) s2 " +
            "ON s1.city = s2.city " +
            "WHERE s1.per > s2.avg_per " +
            "AND s2.count >= :studentCount",
            nativeQuery = true
    )
    public List<Student> getByPerGreaterThanAvgPerOfSameCityHavingStudentCountGreaterThanEqual(@Param("studentCount") Integer studentCount);



}
