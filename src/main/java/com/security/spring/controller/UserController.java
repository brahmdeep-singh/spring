package com.security.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring.model.Users;
import com.security.spring.service.UserService;

@RestController 
public class UserController {
    
    @Autowired 
    private UserService service;
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.register(user);
    }
}
