package com.lxisoft.taskgame.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxisoft.taskgame.model.Cell;
import com.lxisoft.taskgame.model.Player;
import com.lxisoft.taskgame.model.QuestionBank;
import com.lxisoft.taskgame.model.User;
import com.lxisoft.taskgame.service.CellService;
import com.lxisoft.taskgame.service.PlayerService;
import com.lxisoft.taskgame.service.QuestionBankService;
import com.lxisoft.taskgame.service.UserService;


@Controller
public class TaskController {

    @Autowired
    private QuestionBankService qbService;

    @Autowired
    private CellService cellService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String getIndex(){
        System.out.println("this is index");
        return "index";
    }
    
    @GetMapping("/login")
    public String getLoginPage(){
        System.out.println("enterd into login page");
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUpPage(Model model){
        System.out.println("this is signup page");
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/addUser")
    public String addingNewUser(@ModelAttribute User user){
        System.out.println("adding new user");
        userService.addUser(user);
        System.out.println("USER ADDED");
        User currentUser = userService.getUserByUserName(user.getUserName());
        playerService.addPlayer(currentUser);
        System.out.println("player added");
        return "index";
    }
    
    @GetMapping("/gethome")
    public String getHome(Model model){
        
        String name = userService.getCurrentUserName();
        model.addAttribute("name",name);
        User currentUser = userService.getCurrentUser();
        Player currentPlayer =playerService.getPlayerByCurrentUser(currentUser);

        Map<Long ,Map<String,Long>> cellQbTypeCount = new HashMap<>();
        for(Cell cell : currentPlayer.getCell()){
            Map <String,Long> questionTypeCount = cell.getPrepQB().stream()
            .collect(Collectors.groupingBy(QuestionBank::getQuestionType,Collectors.counting()));
            cellQbTypeCount.put(cell.getId(), questionTypeCount);
        }

        Map<Long,Map<String,Long>>cellFinalQbTypeCount = new HashMap<>();
        for(Cell cell : currentPlayer.getCell()){
            Map<String,Long>finalQbCount =cell.getFinalQB().stream()
            .collect(Collectors.groupingBy(QuestionBank::getQuestionType,Collectors.counting()));
            cellFinalQbTypeCount.put(cell.getId(),finalQbCount);
        }

        Map<String,String> questionTypeImages = new HashMap<>();
        questionTypeImages.put("oneWord","images/o.jpg");
        questionTypeImages.put("objective","images/m.jpg");
        questionTypeImages.put("hackathon","images/h.jpg");
        questionTypeImages.put("speech","images/s.jpg");

        model.addAttribute("currentPlayer",currentPlayer);
        model.addAttribute("cellQbTypeCount",cellQbTypeCount);
        model.addAttribute("cellFinalQbTypeCount",cellFinalQbTypeCount);
        model.addAttribute("questionTypeImages",questionTypeImages);
        System.out.println("This is home 2");
        return "home";
    }

    @GetMapping("/addproject")
    public String getAddProject(Model model){
        System.out.println("entered add project");
        QuestionBank qb = new QuestionBank();
        model.addAttribute("qb",qb);
        return "addproject";
    }

    @PostMapping("/addNewProject")
    public String addNewProject(@ModelAttribute QuestionBank qb){
        qbService.addNewQuestion(qb);
        return "home"; 
    }

    @GetMapping("/showCell/{id}")
    public String showTheCell(@PathVariable("id") Long id,Model model) {
        Cell cell = cellService.getCellById(id);
        System.out.println("this is cell info");
        System.out.println(cell.getPrepQB().get(0).getQuestion());
        model.addAttribute("cell",cell);
        return "displayCell";
    }

    @GetMapping("/showTheQuestion/{id}")
    public String showQuestionsInCell(@PathVariable("id")Long id,Model model){
        QuestionBank cellQB = qbService.getQuestionBankById(id);
        model.addAttribute("cellQB",cellQB);
        return "showQuestion";
    }

    @GetMapping("/answerCheck/{id}")
    public String checkingAnswer(@PathVariable("id") Long id , @RequestParam("answer")String answer){
        System.out.println("answer checking");
        if(qbService.checkingTheAnswer(id,answer)){
            Player player = playerService.getCurrentPlayer();
            playerService.addPoints(player);
            System.out.println(player.getId()+"point added");
        }
        return "redirect:/gethome";  
    }
}