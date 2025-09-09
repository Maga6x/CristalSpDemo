package com.example.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

//    @Test
//    void testPassword() {
//        var encoder = new BCryptPasswordEncoder();
//        String raw = "qwerty"; // пароль, который ты вводишь в Postman
//        String hash = "$2a$10$zNhbW/bayIk6i09xc1nkU0a97AqgMHx07YUJJ3Utq4r2eNh6OE2RW"; // возьми из БД
//
//        System.out.println("Пароль совпадает? " + encoder.matches(raw, hash));
//    }
    @Test
    void testPassword() {
        var encoder = new BCryptPasswordEncoder();
        System.out.println("NEW HASH: " + encoder.encode("qwerty"));  // сгенерит новый валидный хэш
    }

}
