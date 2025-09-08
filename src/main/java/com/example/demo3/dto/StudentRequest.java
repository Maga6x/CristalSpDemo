package com.example.demo3.dto;

import com.example.demo3.entity.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    private String firstName;
    private String lastName;
    private Integer age;
    private Long lessonsId;
}
