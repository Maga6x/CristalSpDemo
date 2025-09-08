package com.example.demo3.service.impl;


import com.example.demo3.dto.StudentResponse;
import com.example.demo3.entity.Student;
import com.example.demo3.mapper.StudentMapper;
import com.example.demo3.repository.StudentRepository;
import com.example.demo3.service.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager em;

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> getStudents(String firstName, String lastName, Integer age) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();
        if (firstName != null && !firstName.isBlank()) {
            predicates.add(cb.equal(root.get("firstName"), firstName));
        }
        if (lastName != null && !lastName.isBlank()) {
            predicates.add(cb.equal(root.get("lastName"), lastName));
        }
        if (age != null) {
            predicates.add(cb.equal(root.get("age"), age));
        }

        cq.select(root).where(predicates.toArray(new Predicate[0]));

        List<Student> students = em.createQuery(cq).getResultList();
        return students.stream()
                .map(student->StudentMapper.INSTANCE.toDto(student))
                .toList();
    }

}

