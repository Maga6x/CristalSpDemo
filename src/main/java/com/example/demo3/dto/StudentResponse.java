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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<Lesson> lessons;
}
