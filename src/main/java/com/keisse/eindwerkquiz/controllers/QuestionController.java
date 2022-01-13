package com.keisse.eindwerkquiz.controllers;

import com.keisse.eindwerkquiz.models.Question;
import com.keisse.eindwerkquiz.models.Room;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import com.keisse.eindwerkquiz.services.RoomService;
import com.keisse.eindwerkquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: not sure if this is the way to go
@Controller
public class QuestionController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private QuizQuestionService quizQuestionService;

    @GetMapping("/PlayingPage")
    public String quizPage(String userName, Model model, HttpSession session) throws IOException {

        Long id = (Long) session.getAttribute("roomId");
        Room room = roomService.findById(id).get();

        List<Question> questionList = new ArrayList<>();


        Question question;

        if (session.getAttribute("questions") == null) {
            question = quizQuestionService.findById(1L).get();
        } else {
            question = (Question) session.getAttribute("questions");
            question = quizQuestionService.findById(question.getId() + 1).get();
        }

        questionList.add(question);
//        quizQuestionService.save(question);
        room.setQuestions(questionList);
        model.addAttribute("room", room);
        model.addAttribute("questions", room.getQuestions());
        session.setAttribute("questions",question);



        return "PlayingPage";
    }

    @GetMapping("/PlayingPage2")
    public String quizPage2(String userName, Model model, HttpSession session) throws IOException {

//        try{
//            URL url = new URL("https://opentdb.com/api.php?amount=30&category=15&difficulty=medium&type=multiple");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//
//            StringBuilder informationString = new StringBuilder();
//            Scanner scanner = new Scanner(url.openStream());
//
//            while (scanner.hasNext()){
//                informationString.append(scanner.nextLine());
//                System.out.println(informationString);
//            }
//            scanner.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        Long id = (Long) session.getAttribute("roomId");
//        Room room = roomService.findById(id).get();
//
//        questionList.add(question);
////        quizQuestionService.save(question);
//        room.setQuestions(questionList);
//        model.addAttribute("room", room);
//        model.addAttribute("questions", room.getQuestions());
//        session.setAttribute("questions",question);



        return "PlayingPage";
    }

}
