package com.springboot.rest.SpringBoot_RestAPI.repository;

import com.springboot.rest.SpringBoot_RestAPI.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByLastName(String lastName);
}
