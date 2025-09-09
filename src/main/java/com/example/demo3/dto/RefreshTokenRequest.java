package com.example.demo3.dto;

import lombok.Builder;

@Builder
public record RefreshTokenRequest(
        String refreshToken
){
}
