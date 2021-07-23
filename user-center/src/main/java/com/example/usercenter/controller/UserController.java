package com.example.usercenter.controller;

import com.example.usercenter.model.UserEntity;
import com.example.usercenter.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserManagerService userManagerService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserInfoById(String id) {

        Optional<UserEntity> userEntityOpt = userManagerService.getUserInfoById(id);
        return userEntityOpt.map(userEntity -> ResponseEntity.status(HttpStatus.OK).body(userEntity)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @PostMapping
    public ResponseEntity<Boolean> addUser(UserEntity user) {

        boolean rst = userManagerService.registerUser(user);
        return ResponseEntity.ok(rst);
    }
}
