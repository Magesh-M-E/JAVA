package com.lxisoft.taskgame.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lxisoft.taskgame.model.User;
import com.lxisoft.taskgame.repository.UserRepository;

@Service
public class GetUserDetails implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String name)throws UsernameNotFoundException{
        User user = userRepository.findByUserName(name);
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
        user.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

}
