package com.keisse.eindwerkquiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/LoggedOut")
    public String home(Model model) {

        return "index";
    }

    @RequestMapping("/LoggedIn")
    public String loggedIn(Model model){

        return "indexLoggedIn";
    }
}
