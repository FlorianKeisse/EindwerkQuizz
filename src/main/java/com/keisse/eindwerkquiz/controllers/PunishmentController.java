package com.keisse.eindwerkquiz.controllers;

import com.keisse.eindwerkquiz.models.Punishment;
import com.keisse.eindwerkquiz.models.Question;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import com.keisse.eindwerkquiz.services.RoomService;
import com.keisse.eindwerkquiz.services.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class PunishmentController {

 @Autowired
 private PunishmentService punishmentService;

 @Autowired
 private QuizQuestionService quizQuestionService;

 @Autowired
 private RoomService roomService;



  @GetMapping("/PunishmentPage")
  public String getPage(@RequestParam String AnswerId,HttpSession session){
   Question question = (Question) session.getAttribute("questions");
   Integer points = (Integer) session.getAttribute("userpoints");

   System.out.println(AnswerId);
   System.out.println(question.getCorrectAnswer());
   System.out.println(question.getCorrectAnswer().equals(AnswerId));

   if (question.getCorrectAnswer().equals(AnswerId)){
    points++;
    session.setAttribute("userpoints", points);
    return "redirect:correctPage";
   }else {
    long min = 1L;
    long max = 5L;
    long random = (long) (Math.random() * ((max - min) + 1) + min);
    Punishment punishment = punishmentService.findById(random).get();
//    Punishment punishment = (Punishment) punishmentService.findAll();
    session.setAttribute("punishment", punishment);
    return "/PunishmentPage";
   }

//   question.getCorrectAnswer();
  }

  @GetMapping("/PunishmentPage/{answerId}")
 public String getRoom(long questionId) {

//   System.out.println(answerId);
//   Question question;
//   if (quizQuestionService.findById(questionId).isPresent()) {
//    question = quizQuestionService.findById(questionId).get();
//   }
//   session.setAttribute("questionId",questionId);
//   quizQuestionService.save(question);

  return "";
 }

 @GetMapping("/correctPage")
 public String redirect(Model model) {


  return "correctPage";
 }
//  @GetMapping("/PunishmentPage")
// public String tempUsername(@RequestParam("answerId") long answerId, Model model, HttpSession session) {
//
//  Question question;
//  if (quizQuestionService.findById(answerId).isPresent()) {
//   question = quizQuestionService.findById(answerId).get();
//  }
//
//  session.setAttribute("answerId", answerId);
//
//  quizQuestionService.save(question);
//
//  return "PunishmentPage";
//  }

}
