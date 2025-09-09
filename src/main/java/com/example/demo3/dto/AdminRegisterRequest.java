package com.example.demo3.dto;

import lombok.Builder;

@Builder
public record AdminRegisterRequest(
        String adminName,
        String password,
        String email
){
}
