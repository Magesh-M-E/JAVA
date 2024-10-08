package com.lxisoft.taskgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.taskgame.model.Cell;

@Repository
public interface  CellRepository extends JpaRepository<Cell, Long>{
    
}