package com.lxisoft.taskgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.taskgame.model.Role;
import com.lxisoft.taskgame.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
      
    public Role getRoleByName(String name){
       return roleRepository.findRoleByName(name);
    }

}
