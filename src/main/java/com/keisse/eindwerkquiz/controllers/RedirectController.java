package com.keisse.eindwerkquiz.controllers;


import com.keisse.eindwerkquiz.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @Autowired
    RoomService roomService;

    @GetMapping("/JoinRedirect")
    public String redirect(Model model) {


        return "JoinRedirect";
    }

}
