package com.lxisoft.taskgame.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class QuestionBank{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String questionType;

    @Column(nullable=false)
    private String question;

    @Column(nullable=false)
    private String answer;

    @Column(nullable=true)
    private String option_a;

    @Column(nullable=true)
    private String option_b;

    @Column(nullable=true)
    private String option_c;

    @Column(nullable=true)
    private String option_d;

    @Column(nullable = true)
    private Long level;
    
    @ManyToMany(mappedBy="prepQB")
    private List <Cell> cells;

    @ManyToMany(mappedBy="finalQB")
    private List <Cell>finalCells;

    public List<Cell> getFinalCells() {
        return finalCells;
    }

    public void setFinalCells(List<Cell> finalCells) {
        this.finalCells = finalCells;
    }

    @OneToMany(mappedBy = "questionBank")
    private List<PlayerCellQuestion> playerCellQuestions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        QuestionBank qb = (QuestionBank)obj;
        if(this.getId()==qb.getId()){
            return true;
        }
        else{
            return false;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String Question) {
        this.question = Question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_A) {
        this.option_a = option_A;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<PlayerCellQuestion> getPlayerCellQuestions() {
        return playerCellQuestions;
    }

    public void setPlayerCellQuestions(List<PlayerCellQuestion> playerCellQuestions) {
        this.playerCellQuestions = playerCellQuestions;
    }
    
}