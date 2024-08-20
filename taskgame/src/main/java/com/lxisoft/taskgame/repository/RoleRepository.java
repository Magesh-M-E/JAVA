package com.lxisoft.taskgame.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.taskgame.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    public Role findRoleByName(String name);

}
