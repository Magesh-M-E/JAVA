package com.lxisoft.taskgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.taskgame.model.User;


public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUserName(String userName);
}
