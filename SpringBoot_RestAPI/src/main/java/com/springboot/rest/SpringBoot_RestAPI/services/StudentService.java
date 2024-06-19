package com.springboot.rest.SpringBoot_RestAPI.services;

import com.springboot.rest.SpringBoot_RestAPI.models.Student;
import com.springboot.rest.SpringBoot_RestAPI.repository.StudentRepository;
import com.springboot.rest.SpringBoot_RestAPI.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(new ApiResponse<>("Students retrieved successfully", students), HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse<Student>> getStudent(Long id) {
        return studentRepository.findById(id)
                .map(student -> new ResponseEntity<>(new ApiResponse<>("Student found", student), HttpStatus.OK))
                .orElse(new ResponseEntity<>(new ApiResponse<>("Student not found", null), HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ApiResponse<Student>> createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(new ApiResponse<>("Student created successfully", savedStudent), HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse<Void>> removeStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse<>("Student removed successfully", null), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(new ApiResponse<>("Student not found", null), HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsByLastName(String lastName) {
        List<Student> students = studentRepository.findByLastName(lastName);
        if (!students.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse<>("Students found", students), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse<>("No students found with last name: " + lastName, null), HttpStatus.NOT_FOUND);
        }
    }
}
