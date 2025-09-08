package com.example.demo3.dto;

import com.example.demo3.entity.Lesson;
import lombok.*;

import java.util.List;



@Builder
public record StudentRequest
        (
                String firstName,
                String lastName,
                Integer age,
                Long lessonsId
        ){}
