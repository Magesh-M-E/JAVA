package com.lxisoft.taskgame.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Player{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="player_cell",
    joinColumns=@JoinColumn(name="player_id"),
    inverseJoinColumns=@JoinColumn(name="cell_id"))
    private Cell[] cell;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "player")
    private List<PlayerCellQuestion> playerCellQuestions;

    private Long points;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cell[] getCell() {
        return cell;
    }

    public void setCell(Cell[] cell) {
        this.cell = cell;
    }

    public List<PlayerCellQuestion> getPlayerCellQuestions() {
        return playerCellQuestions;
    }

    public void setPlayerCellQuestions(List<PlayerCellQuestion> playerCellQuestions) {
        this.playerCellQuestions = playerCellQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
    
}