package com.example.demo3.dto;

import com.example.demo3.entity.Lesson;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Builder
public record StudentResponse (
        Long id,
        String firstName,
        String lastName,
        Integer age,
        List<Lesson> lessons
){}
