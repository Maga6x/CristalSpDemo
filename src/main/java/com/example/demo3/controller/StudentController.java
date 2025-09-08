package com.example.demo3.controller;


import com.example.demo3.dto.StudentRequest;
import com.example.demo3.dto.StudentResponse;
import com.example.demo3.entity.Student;
import com.example.demo3.exception.EntityNotFoundException;
import com.example.demo3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudent(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Integer age
    ) {
        try {
            List<StudentResponse> students = studentService.getStudents(firstName, lastName, age);
            return ResponseEntity.ok(students);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<StudentResponse> getStudentById(@RequestParam Long id) {
        try {
            StudentResponse student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody StudentRequest request){
        try {
            studentService.createStudent(request);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
