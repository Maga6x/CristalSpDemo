package com.example.demo3.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record LessonResponse
        (
        String name,
        List<StudentResponse> students
        ){}
