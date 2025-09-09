package com.example.demo3.dto;

import lombok.Builder;

@Builder
public record UserRegisterRequest(
        String username,
        String password,
        String rePassword,
        String fullName,
        String gender,
        Integer age
){
}
