package com.lxisoft.taskgame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.taskgame.model.Cell;
import com.lxisoft.taskgame.model.QuestionBank;
import com.lxisoft.taskgame.repository.CellRepository;
import com.lxisoft.taskgame.repository.QuestionBankRepository;

@Service
public class CellService {

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private QuestionBankService qbService;

    @Autowired
    private QuestionBankRepository questionBankRepository;


//METHOD FOR GETTING THE CELL BY THE QB LEVEL
   /*  public Cell getCellByQbLevCell(int level){
        storedCells = new ArrayList<>();
        List <Cell> cellByQbLevel = cellRepository.findAll();
        Cell cell =null;
        for(Cell c : cellByQbLevel){
            if(c.getQb().getLevel()== level){
                cell =c;
                break;
            }
        }
        return cell;
    } */

    //METHOD FOR GET A RANDOM ONE WORD QUESTION
    public QuestionBank getQuestion(String type, Long level) {
        List<QuestionBank> questionsByIdAndType = qbService.getByQuestionTypeAndLevel(type, level);
        if (questionsByIdAndType.isEmpty()) {
            throw new RuntimeException("No questions available for the given type and level");
        }
        int index = (int) (Math.random() * questionsByIdAndType.size());
        return questionsByIdAndType.get(index);
    }
    

    //METHOD FOR GENARATING 100 CELLS
    public Cell[] generateCells(){
        System.out.println("cell creating");
        Cell[] cells = new Cell[100];
        if(cellRepository.count()== 0){ 
            for(int i=0; i<100; i++){
                
                    cells[i] = new Cell();

                    if(i<10){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)1));
                        prepQuestionBanks.add(getQuestion("objective",(long)1));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)1));
                        prepQuestionBanks.add(getQuestion("speech",(long)1));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) {
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);
                    }
                    if(i>=10 && i<20){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)2));
                        prepQuestionBanks.add(getQuestion("objective",(long)2));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)2));
                        prepQuestionBanks.add(getQuestion("speech",(long)2));

                        while (finalQuestionBanks.size() < 3) {
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);
                    }
                    if(i>=20 && i<30){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)3));
                        prepQuestionBanks.add(getQuestion("objective",(long)3));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)3));
                        prepQuestionBanks.add(getQuestion("speech",(long)3));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                  
                    }
                    if(i>=30 && i<40){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)3));
                        prepQuestionBanks.add(getQuestion("objective",(long)3));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)3));
                        prepQuestionBanks.add(getQuestion("speech",(long)3));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                  
                    }
                    if(i>=40 && i<50){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)5));
                        prepQuestionBanks.add(getQuestion("objective",(long)5));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)5));
                        prepQuestionBanks.add(getQuestion("speech",(long)5));

                        while (finalQuestionBanks.size() < 3) {
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                    
                    } 
                    if(i>=50 && i<60){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)6));
                        prepQuestionBanks.add(getQuestion("objective",(long)6));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)6));
                        prepQuestionBanks.add(getQuestion("speech",(long)6));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                     
                    }
                    if(i>=60 && i<70){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)7));
                        prepQuestionBanks.add(getQuestion("objective",(long)7));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)7));
                        prepQuestionBanks.add(getQuestion("speech",(long)7));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                    
                    }
                    if(i>=70 && i<80){
                            List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                            List <QuestionBank> finalQuestionBanks = new ArrayList<>();
    
                            prepQuestionBanks.add(getQuestion("oneWord",(long)8));
                            prepQuestionBanks.add(getQuestion("objective",(long)8));
                            prepQuestionBanks.add(getQuestion("hackathon",(long)8));
                            prepQuestionBanks.add(getQuestion("speech",(long)8));
    
                            while (finalQuestionBanks.size() < 3) { 
                                int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                                QuestionBank question = prepQuestionBanks.get(prepIndex);
                                
                                if (!finalQuestionBanks.contains(question)) {
                                    finalQuestionBanks.add(question);
                                }
                            }
                                cells[i].setPrepQB(prepQuestionBanks);
                                cells[i].setFinalQB(finalQuestionBanks);                        
                    }
                    if(i>=80 && i<90){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)9));
                        prepQuestionBanks.add(getQuestion("objective",(long)9));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)9));
                        prepQuestionBanks.add(getQuestion("speech",(long)9));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) {
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                      
                    }
                    if(i>=90 && i<100){
                        List <QuestionBank> prepQuestionBanks = new ArrayList<>();
                        List <QuestionBank> finalQuestionBanks = new ArrayList<>();

                        prepQuestionBanks.add(getQuestion("oneWord",(long)10));
                        prepQuestionBanks.add(getQuestion("objective",(long)10));
                        prepQuestionBanks.add(getQuestion("hackathon",(long)10));
                        prepQuestionBanks.add(getQuestion("speech",(long)10));

                        while (finalQuestionBanks.size() < 3) { 
                            int prepIndex = (int) (Math.random() * prepQuestionBanks.size());
                            QuestionBank question = prepQuestionBanks.get(prepIndex);
                            
                            if (!finalQuestionBanks.contains(question)) { 
                                finalQuestionBanks.add(question);
                            }
                        }
                            cells[i].setPrepQB(prepQuestionBanks);
                            cells[i].setFinalQB(finalQuestionBanks);                     
                    }
                    cellRepository.save(cells[i]);
                }
            return cells;
            }
            
        
        else{      
              for(int i =0;i<100;i++){
                
                    if(questionBankRepository.count()!=0){
                        cells[i] = getCellById((long)i+1);    
                    }
                    else{
                        System.out.println("qb is null");
                    }
                }
            return cells;
        }    
    }

    public Cell getCellById(Long id){
        Cell cell =null;
        Optional<Cell>cellOptional = cellRepository.findById(id);
        if(cellOptional.isPresent()){
            cell = cellOptional.get();
        }
        return cell;
    }
}
