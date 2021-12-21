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
import java.util.ArrayList;
import java.util.List;
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
    public String quizPage(String userName, Model model, HttpSession session) { //todo: Aanpassen van Controller voor vragen af te printen

        Long id = (Long) session.getAttribute("roomId");
        Room room = roomService.findById(id).get();

        List<Question> questionList = new ArrayList<>();

        Question question = new Question();

        question.setQuestion("How big is the mount everest?");

        question.setAnswer1("very big");
        question.setAnswer2("very small");
        question.setAnswer3("very thicc");
        question.setAnswer4("very smoll");

        questionList.add(question);

        question.setCorrectAnswer(question.getAnswer3());
        quizQuestionService.save(question);

        room.setQuestions(questionList);
        model.addAttribute("room",room);
        model.addAttribute("questions",room.getQuestions());

//        System.out.println(quizq);

        return "PlayingPage";
    }



}
