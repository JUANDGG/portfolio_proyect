package com.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.services.user.UserServiceImpl;
import com.persistence.dto.UserDTO;
import com.persistence.dto.UserWithPasswordHashDTO;
import com.persistence.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/api/user/all", method=RequestMethod.GET)
    public List<User> requestMethodName() {
        return userServiceImpl.getAllUsers();
    }
    

    @RequestMapping(value = "/api/user",method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUserWithPasswordHash(@RequestBody UserWithPasswordHashDTO userWithPasswordHashDTO) {
        UserDTO createdUser = userServiceImpl.createUserWithPasswordHash(userWithPasswordHashDTO.getUserDto(), userWithPasswordHashDTO.getPasswordHashDTO());
        return ResponseEntity.ok(createdUser);
    }
}
