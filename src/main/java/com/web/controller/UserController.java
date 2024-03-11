package com.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistence.dto.UserDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "api/user")
public class UserController {
    


    @PostMapping
    public String postMethodName(@RequestBody UserDTO UserDTO) {
        
        
        return entity;
    }
    
}
