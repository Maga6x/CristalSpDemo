package com.example.demo3.mapper;

import com.example.demo3.dto.StudentResponse;
import com.example.demo3.entity.Student;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentResponse toDto(Student student);

    Student toEntity(StudentResponse studentResponse);
}
