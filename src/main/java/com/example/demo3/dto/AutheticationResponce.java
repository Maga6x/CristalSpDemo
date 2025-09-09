package com.example.demo3.dto;

import lombok.Builder;

@Builder
public record AutheticationResponce(
        String accessToken,
        String refreshToken
){
}
