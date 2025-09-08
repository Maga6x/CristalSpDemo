package com.example.demo3.mapper;

import com.example.demo3.dto.StudentRequest;
import com.example.demo3.dto.StudentResponse;
import com.example.demo3.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentResponse toDto(Student student);
    @Mapping(target = "id", ignore = true)
    Student toEntity(StudentRequest request);
}
