package com.example.demo3.service;

import com.example.demo3.dto.StudentRequest;
import com.example.demo3.dto.StudentResponse;
import com.example.demo3.entity.Student;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getStudents(String firstName, String lastName, Integer age);

    StudentResponse getStudentById(Long id);

    void createStudent(StudentRequest request);


}
