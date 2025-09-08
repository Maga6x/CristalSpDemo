package com.example.demo3.dto;

import com.example.demo3.entity.Lesson;
import com.example.demo3.entity.Student;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
public record LessonResponse
        (
        String name,
        List<StudentResponse> students
        ){}
