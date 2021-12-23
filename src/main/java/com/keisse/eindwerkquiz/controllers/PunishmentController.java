package com.keisse.eindwerkquiz.controllers;

import com.keisse.eindwerkquiz.services.UserScoreService;
import com.keisse.eindwerkquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PunishmentController {

 @Autowired
 private UserScoreService userService;

 @GetMapping("/PunishmentPage")
 public String redirect(Model model) {

     return "PunishmentPage";
 }
}
