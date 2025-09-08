package com.example.demo3.dto;

import com.example.demo3.entity.Lesson;
import com.example.demo3.entity.Student;
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
public class LessonResponse {

    private String name;
    private List<StudentResponse> students;
}
