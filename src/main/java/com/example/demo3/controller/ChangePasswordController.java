package com.example.demo3.controller;

import com.example.demo3.exception.IncorrectRequestException;
import com.example.demo3.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/change-password")
@RequiredArgsConstructor
@Slf4j
public class ChangePasswordController {

    private final ChangePasswordService changePasswordService;

    @PutMapping
    public ResponseEntity<?> changePassword(
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            @RequestParam String reNewPassword
    ) {
        try {
            changePasswordService.changePassword(oldPassword, newPassword, reNewPassword);
            return ResponseEntity.ok().build();
        } catch (IncorrectRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}