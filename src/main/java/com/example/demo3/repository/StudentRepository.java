package com.example.demo3.repository;

import com.example.demo3.dto.StudentResponse;
import com.example.demo3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
        select s from Student s
        where (:firstName is null or s.firstName = :firstName)
          and (:lastName  is null or s.lastName  = :lastName)
          and (:age       is null or s.age       = :age)
    """)
    List<Student> search(@Param("firstName") String firstName,
                         @Param("lastName")  String lastName,
                         @Param("age")       Integer age);

    Optional<Student> findById(Long id);
}
