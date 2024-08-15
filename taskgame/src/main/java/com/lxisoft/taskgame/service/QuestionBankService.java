package com.lxisoft.taskgame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.taskgame.model.QuestionBank;
import com.lxisoft.taskgame.repository.QuestionBankRepository;

@Service
public class QuestionBankService{
    
    @Autowired
    private QuestionBankRepository qbRepoitory;

    public void addNewQuestion(QuestionBank qb){
        if(!qb.getQuestionType().equals("objective")){
            qb.setOption_a(null);
            qb.setOption_b(null);
            qb.setOption_c(null);
            qb.setOption_d(null);
        }
        qbRepoitory.save(qb);
    }

    public QuestionBank getQbByLevel(int level){
        return qbRepoitory.findByLevel(level);
    }

    public List<QuestionBank>getByQuestionTypeAndLevel(String questionType,Long level){
        return qbRepoitory.getByQuestionTypeAndLevel(questionType,level);
    }

    public QuestionBank getQuestionBankById(Long id){
        Optional<QuestionBank> myQb = qbRepoitory.findById(id);
        if(myQb.isPresent()){
            return myQb.get();
        }
        else{
            System.out.println("qb is null");
            return new QuestionBank();
        }
    }

    public boolean checkingTheAnswer(Long id,String answer){
        Optional <QuestionBank> qbOptional = qbRepoitory.findById(id);
        QuestionBank thisQuestion = qbOptional.get();
        return thisQuestion.getAnswer().equals(answer);
    }
}