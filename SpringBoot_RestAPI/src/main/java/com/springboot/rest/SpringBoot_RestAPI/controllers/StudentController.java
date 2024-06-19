package com.springboot.rest.SpringBoot_RestAPI.controllers;

import com.springboot.rest.SpringBoot_RestAPI.models.Student;
import com.springboot.rest.SpringBoot_RestAPI.response.ApiResponse;
import com.springboot.rest.SpringBoot_RestAPI.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
    @GetMapping("/students/lastname/{lastName}")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @PostMapping("/students")
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<ApiResponse<Void>> removeStudent(@PathVariable Long id) {
        return studentService.removeStudent(id);
    }

}
