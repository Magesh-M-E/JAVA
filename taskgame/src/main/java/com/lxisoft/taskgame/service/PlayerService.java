package com.lxisoft.taskgame.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.taskgame.model.*;
import com.lxisoft.taskgame.repository.CellRepository;
import com.lxisoft.taskgame.repository.PlayerRepository;
import com.lxisoft.taskgame.repository.UserRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private CellService cellservice;

    @Autowired
    private UserService userService;

    public void addPlayer(User user){
        Player player = new Player();
        player.setCell(cellservice.generateCells());
        player.setUser(user);
        player.setPoints((long)0);
        playerRepository.save(player);    
    }

    public Player getPlayerByCurrentUser(User user){
        return playerRepository.getPlayerByUser(user);       
    }

    public Player getCurrentPlayer(){
        User user = userService.getCurrentUser();
        return getPlayerByCurrentUser(user);
    }

    public void addPoints(Player player){
        System.out.println(player.getPoints());
        long newPoint =player.getPoints()+10;
        player.setPoints(newPoint);
        playerRepository.save(player);
        System.out.println("10 points added");
    }
}
