package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test_getUserByEmail() {
        User user = userService.getUserByEmail("tien@gmail.com");
//        System.out.println(user);
        System.out.println(user.getRoles());
    }

    @Test
    public void test_setUserByEmail() {
//        User user = userService.getUserByEmail("
        User user = userService.setUserByEmail("tien@gmail.com");
        System.out.println(user);
    }
}