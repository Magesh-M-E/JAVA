package com.lxisoft.taskgame.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lxisoft.taskgame.model.*;
import com.lxisoft.taskgame.repository.*;

@Service
public class UserService{

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    public void addUser(User user){
        User newUser = new User();
        List <Role> userRoles = new ArrayList<>();
        userRoles.add(roleService.getRoleByName("user"));
        newUser.setUserName(user.getUserName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(userRoles);
        userRepository.save(newUser);
   }

    public User getUserByUserName(String userName){
        return userRepository.findByUserName(userName);
   }

    public User getCurrentUser(){
        String name=getCurrentUserName();
        return userRepository.findByUserName(name);
    }

    public String getCurrentUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            return authentication.getName();
        }
        else{
            return "no user found";
        }
    }
  
}
