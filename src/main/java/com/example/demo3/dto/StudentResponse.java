package com.example.demo3.dto;

import com.example.demo3.entity.Lesson;
import lombok.Builder;
import java.util.List;

@Builder
public record StudentResponse (
        Long id,
        String firstName,
        String lastName,
        Integer age,
        List<Lesson> lessons
){}
