package com.tca.repository;

import com.tca.entity.Gender;
import com.tca.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
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
     */

    /* Find all students whose percentage is greater than 75. */
    @Query("SELECT s FROM Student s WHERE s.per > :per")    // JPQL
    public List<Student> fetchByPerGreaterThan(Double per);

    @Query(name = "SELECT * FROM STUDENT WHERE PER > :per", nativeQuery = true) // NATIVE SQL
    public List<Student> getByPerGreaterThan(Double per);

    /* Find the student whose id is 101. */
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    public Optional<Student> fetchById(@Param("id") Integer id);

    @Query(name="SELECT * FROM STUDENT WHERE ID = :id", nativeQuery = true)
    public Optional<Student> getByID(@Param("id") Integer id);


    /* Find all students who live in Pune. */
    @Query("SELECT s FROM Student s WHERE s.city LIKE :city")
    public List<Student> fetchByCity(@Param("city") String city);

    @Query(name="SELECT * FROM STUDENT WHERE CITY LIKE :city", nativeQuery = true)
    public List<Student> getByCity(@Param("city") String city);


    /* Find all female students. */
    @Query("SELECT s FROM Student s WHERE s.gender = :gender")
    public List<Student> fetchByGender(Gender gender);

    @Query(name="SELECT * FORM STUDENT WHERE GENDER = :gender", nativeQuery = true)
    public List<Student> getByGender(@Param("gender") Gender gender);


    /* Find all students whose percentage is between 60 and 80, inclusive. */
    @Query("SELECT s FROM Student s WHERE s.per BETWEEN :from AND :to")
    public List<Student> fetchByPerBetween(
            @Param("from") Double fromPer,
            @Param("to") Double toPer
    );

    @Query(name="SELECT * FROM STUDENT WHERE PER BETWEEN :from AND :to", nativeQuery = true)
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

    @Query(name="SELECT * FROM STUDENT WHERE CITY LIKE :city AND PER > :per", nativeQuery = true)
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

    @Query(name="SELECT * FROM STUDENT WHERE GENDER = :gender AND PER >= :per", nativeQuery = true)
    public List<Student> getByGenderAndPerGreaterThanEqual(
            @Param("gender") Gender gender,
            @Param("per") Double per
    );


    /* Find students whose name starts with "A". */
    @Query("SELECT s FROM Student s WHERE s.name LIKE CONCAT(:namePrefix, '%') ")
    public List<Student> fetchByNameStartingWith(@Param("namePrefix") String namePrefix);

    @Query( name="SELECT * FROM STUDENT WHERE NAME LIKE CONCAT(:namePrefix, '%')", nativeQuery = true)          // I am using mariadb so it will work for now !!
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

    @Query(name="SELECT * FROM STUDENT WHERE BIRTHDATE BETWEEN :from and :to", nativeQuery = true)
    public List<Student> getByBirthDateBetween(
            @Param("from") LocalDate fromBirthDate,
            @Param("to") LocalDate toBirthDate
    );


    /* Find students whose name contains a supplied search string, ignoring case. */
    @Query("SELECT s FROM Student s WHERE lower(s.name) LIKE CONCAT('%', concat(:name ,'%') ) ")
    public List<Student> fetchByNameContainingIgnoreCase(@Param("name") String name);

    @Query(name="SELECT * FROM STUDENT WHERE LOWER(NAME) LIKE CONCAT('%', CONCAT(:name, '%'))", nativeQuery = true)
    public List<Student> getByNameContainingIgnoreCase(@Param("name") String name);


    /* Find students whose gender belongs to a supplied collection of genders. */
    @Query("SELECT s FROM Student s WHERE s.gender IN :genders")
    public List<Student> fetchByGenderIn(@Param("genders") List<Gender> genders);

    @Query(name = "SELECT * FORM STUDENT WHERE GENDER IN :genders", nativeQuery = true)
    public List<Student> getByGenderIn(@Param("genders") List<Gender> genders);


    /*  Find students whose ID belongs to a supplied collection of IDs and whose percentage is greater than 70. */
    @Query("SELECT s FROM Student s WHERE s.id IN :ids and s.per > :per")
    public List<Student> fetchByIdInAndPerGreaterThan(
            @Param("ids") List<Integer> ids,
            @Param("per") Double per
    );

    @Query(name="SELECT * FROM STUDENTS WHERE ID IN :id AND PER > :per",nativeQuery = true)
    public List<Student> getByIdInAndPerGreaterThan(
            @Param("ids") List<Integer> ids,
            @Param("per") Double per
    );

    /*    Find students whose city is not among given cities  */
    @Query("SELECT s FROM Student s WHERE s.city NOT IN :cities")
    public List<Student> fetchByCityNotIn(@Param("cities") List<String> cities);

    @Query(name="SELECT * FROM STUDENT WHERE CITY NOT IN :cities", nativeQuery = true)
    public List<Student> getByCityNotIn(@Param("cities") List<String> cities);

    /* Find students whose city is NULL. */
    @Query("SELECT s FROM Student s WHERE s.city IS NULl")
    public List<Student> fetchByCityIsNull();

    @Query(name="SELECT * FROM STUDENT WHERE CITY IS NULL", nativeQuery = true)
    public List<Student> getByCityIsNull();


    /* Find students whose city is not NULL. */
    @Query("SELECT s FROM Student s WHERE s.city IS NOT NULl")
    public List<Student> fetchByCityIsNotNull();

    @Query(name="SELECT * FROM STUDENT WHERE CITY IS NOT NULL", nativeQuery = true)
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

    @Query(name="SELECT MAX(PER) FROM STUDENT", nativeQuery = true)
    public Double getMaxPer();

    /* Find the lowest percentage. */
    @Query("SELECT MIN(s.per) FROM Student s")
    public Double fetchMinPer();

    @Query(name="SELECT MIN(PER) FROM STUDENT", nativeQuery = true)
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
    public Double fetchAveragePerByGender(Gender gender);

    @Query(name = "SELECT AVG(PER) FROM STUDENT  WHERE GENDER = :gender", nativeQuery = true)
    public Double getAveragePerByGender(Gender gender);

    
    /*
    Find students whose percentage is greater than the average percentage of students living in their own city,
    but only consider cities having at least 5 students.

    select * from student where per > (
        select
    )

     */

}
