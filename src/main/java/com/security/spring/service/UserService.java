package com.security.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.spring.model.Users;
import com.security.spring.repo.UserRepo;

@Service 
public class UserService {

    @Autowired 
    private UserRepo repo;
    public Users register(Users user){
        return repo.save(user);
    }
}
