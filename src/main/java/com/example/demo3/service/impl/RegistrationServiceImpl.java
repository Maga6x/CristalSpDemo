package com.example.demo3.service.impl;


import com.example.demo3.dto.UserRegisterRequest;
import com.example.demo3.entity.Role;
import com.example.demo3.entity.User;
import com.example.demo3.exception.IncorrectRequestException;
import com.example.demo3.exception.UsernameAlreadyExistException;
import com.example.demo3.mapper.UserMapper;
import com.example.demo3.repository.RoleRepository;
import com.example.demo3.repository.UserRepository;
import com.example.demo3.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public void registerUser(UserRegisterRequest request) {
        boolean usernameIsExist = userRepository.findByUsername(request.username()).isPresent();
        if (usernameIsExist) {
            throw new UsernameAlreadyExistException("Username already exist: " + request.username());
        }

        if (!request.password().equals(request.rePassword())) {
            throw new IncorrectRequestException("Passwords do not match");
        }

        User user = userMapper.toEntity(request);
        user.setPasswordHash(passwordEncoder.encode(request.password()));

        Role role = roleRepository.findRoleUser();
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);
    }
}
