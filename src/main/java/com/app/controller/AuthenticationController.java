package com.app.controller;

import com.app.controller.dto.*;
import com.app.service.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

//    @PostMapping("/signup")
//    public ResponseEntity<AuthResponse> register (@RequestBody @Valid AuthCreateUserRequest authCreateUser){
//        return new ResponseEntity<>(this.userDetailService.createUser(authCreateUser), HttpStatus.CREATED);
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@RequestBody @Validated AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }

}
