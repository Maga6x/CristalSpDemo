package com.example.demo3.service.impl;

import com.example.demo3.entity.User;
import com.example.demo3.exception.IncorrectRequestException;
import com.example.demo3.repository.UserRepository;
import com.example.demo3.service.AuthenticationService;
import com.example.demo3.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {

    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void changePassword(String oldPassword, String newPassword, String reNewPassword) {
        if (!newPassword.equals(reNewPassword)) {
            throw new IncorrectRequestException("New password and re new password do not match");
        }

        User user = authenticationService.currentUser();
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IncorrectRequestException("Incorrect password");
        }

        user.setPasswordHash(passwordEncoder.encode(newPassword));

        userRepository.save(user);
    }
}