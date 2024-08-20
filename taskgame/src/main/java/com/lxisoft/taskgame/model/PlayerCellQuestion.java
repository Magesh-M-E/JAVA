package com.lxisoft.taskgame.model;

import jakarta.persistence.*;

@Entity
public class PlayerCellQuestion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public QuestionBank getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    @ManyToOne
    @JoinColumn(name="cell_id")
    private Cell cell;

    @ManyToOne
    @JoinColumn(name="qb_id")
    private QuestionBank questionBank;
}
