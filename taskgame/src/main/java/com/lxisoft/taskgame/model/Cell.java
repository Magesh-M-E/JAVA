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

@Entity
public class Cell {

   //INSTANCE VARIABLES
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy="cell")
    private List <Player> players;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="cell_qb",
        joinColumns=@JoinColumn(name="cell_id"),
        inverseJoinColumns=@JoinColumn(name="qb_id"))
    private List<QuestionBank> prepQB;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="cell_finalQb",
        joinColumns = @JoinColumn(name="cell_id"),
        inverseJoinColumns = @JoinColumn(name="qb_id")
        )
    private List<QuestionBank>finalQB;

    @OneToMany(mappedBy = "cell")
    private List<PlayerCellQuestion> playerCellQuestions;


    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<QuestionBank> getPrepQB() {
        return prepQB;
    }

    public void setPrepQB(List<QuestionBank> prepQB) {
        this.prepQB = prepQB;
    }

    public List<QuestionBank> getFinalQB() {
        return finalQB;
    }

    public void setFinalQB(List<QuestionBank> finalQB) {
        this.finalQB = finalQB;
    }

    public List<PlayerCellQuestion> getPlayerCellQuestions() {
        return playerCellQuestions;
    }

    public void setPlayerCellQuestions(List<PlayerCellQuestion> playerCellQuestions) {
        this.playerCellQuestions = playerCellQuestions;
    }


    
    @Override
    public boolean equals(Object obj) {
        Cell cell = (Cell)obj;
        if(this.getId().equals(cell.getId())){
            return true;
        }
        else{
            return false;
        }
    }

}
