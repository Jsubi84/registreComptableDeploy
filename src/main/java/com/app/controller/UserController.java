package com.app.controller;

import com.app.controller.dto.*;
import com.app.service.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.app.controller.persistence.entity.UserEntity;
import com.app.service.UserEntityServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping({"/api/v1/users"})
public class UserController extends BaseControllerImpl<UserEntity, UserEntityServiceImpl> {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/passwordRestore")
    public ResponseEntity<?> newPasswordResponse (@RequestBody @Validated NewPasswordRequest newPassword){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updatePassUserById(newPassword.userName(), newPassword.newPassword(), newPassword.oldPassword()));
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/reset/{id}")
    public ResponseEntity<?> resetPasswordResponse (@PathVariable Long id, @RequestBody changePasswordRequest password){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.resetPassUserById(id, password.password()));
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/new")
    public ResponseEntity<NewUserResponse> register (@RequestBody @Valid AuthCreateUserRequest authCreateUser) {
        return new ResponseEntity<>(this.userDetailService.createUser(authCreateUser),  HttpStatus.CREATED);
    }

    @PutMapping(path = {"update/{id}"})
    public ResponseEntity<?> update(@RequestBody @Valid AuthUpdaterUserRequest authUpdaterUserRequest){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(authUpdaterUserRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se ha podido actualizar.\"}");
        }
    }

}
