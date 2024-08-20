package com.lxisoft.taskgame;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.lxisoft.taskgame.model.Role;
import com.lxisoft.taskgame.model.User;
import com.lxisoft.taskgame.repository.RoleRepository;
import com.lxisoft.taskgame.repository.UserRepository;
import com.lxisoft.taskgame.service.QuestionBankService;

@Component
public class DataInitializer implements CommandLineRunner{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionBankService qbService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void run(String[] args) throws Exception{

        Role adminRole = new Role();
        adminRole.setName("admin");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("user");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setPassword(passwordEncoder.encode("password"));
        List <Role> adminRoles = new ArrayList<>();
        adminRoles.add(userRole);
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User userUser =new User();
        userUser.setUserName("user");
        userUser.setPassword(passwordEncoder.encode("password"));
        List<Role>userRoles = new ArrayList<>();
        userRoles.add(userRole);
        userUser.setRole(userRoles);
        userRepository.save(userUser);

        qbService.insertQbFromJsonFile("src/main/resources/json/qbdata.json");

    }
}