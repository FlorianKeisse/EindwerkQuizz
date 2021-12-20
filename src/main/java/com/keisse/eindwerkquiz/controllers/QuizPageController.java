package com.keisse.eindwerkquiz.controllers;


import com.keisse.eindwerkquiz.models.QuizQuestion;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizPageController {

    @Autowired
    private QuizQuestionService quizQuestion;


    @GetMapping("/PlayingPage")
    public String quizPage(Model model) {

        return "PlayingPage";
    }
}
