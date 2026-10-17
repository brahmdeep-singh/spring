package com.security.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.spring.model.UserPrincipal;
import com.security.spring.model.Users;
import com.security.spring.repo.UserRepo;

@Service 
public class MyUserDetailsService implements UserDetailsService{

    @Autowired 
    private UserRepo repo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=repo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }

}
