package com.lxisoft.taskgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxisoft.taskgame.model.Player;
import com.lxisoft.taskgame.model.User;

public interface PlayerRepository extends JpaRepository <Player,Long>{

    public Player getPlayerByUser(User user);
}
