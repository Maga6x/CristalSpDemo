package com.example.demo3.dto;

import lombok.Builder;

@Builder
public record StudentRequest
        (
                String firstName,
                String lastName,
                Integer age,
                Long lessonsId
        ){}
