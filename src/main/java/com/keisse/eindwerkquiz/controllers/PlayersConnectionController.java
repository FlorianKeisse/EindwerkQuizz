package com.keisse.eindwerkquiz.controllers;

import com.keisse.eindwerkquiz.models.Room;
import com.keisse.eindwerkquiz.models.User;
import com.keisse.eindwerkquiz.models.UserScore;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import com.keisse.eindwerkquiz.services.RoomService;
import com.keisse.eindwerkquiz.services.UserScoreService;
import com.keisse.eindwerkquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

//todo: controller mapping

@Controller
//@RequestMapping("/playerConnection")
public class PlayersConnectionController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserScoreService userScoreService;


    @GetMapping("playerconnections")
    public String playerConnections(@RequestParam("Username") String userName, Model model, HttpSession session) {
        session.setAttribute("username", userName);
        Long id = (Long) session.getAttribute("roomId");
        Room room = roomService.findById(id).get();
        List<User> roomList = room.getUsers();

        User user = userService.getUserByUserName(userName);

        if(user==null){
            user=new User();
            user.setUserName(userName);
            userService.saveUser(user);
        }

        if (!roomList.contains(user)) {
            room.setUser(user);
            user.setRoom(room);
            userService.saveUser(user);
        }

//        if (user.isTemp()==true){
//            roomList.remove(user);
//        }

        model.addAttribute("room", room);
        model.addAttribute("users", room.getUsers());
        System.out.println(roomList);
        return "playerconnections";
    }


    @GetMapping("/TempUsername")
    public String tempUsername(@RequestParam("roomId") long roomId, Model model, HttpSession session) {
        Room room;
        if (roomService.findById(roomId).isPresent()) {
            room = roomService.findById(roomId).get();
        } else {
            room = new Room();
            room.setId(roomId);
        }

        session.setAttribute("roomId", roomId);
        System.out.println(room.getId());
        roomService.save(room);

        return "TempUsername";

    }

    @GetMapping("playerconnections/{id}")
    public String getRoom(Model model) {

        return "";
    }

}
