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
    public String quizPage(String userName, Model model, HttpSession session) throws IOException {

        Long id = (Long) session.getAttribute("roomId");
        Room room = roomService.findById(id).get();

        List<Question> questionList = new ArrayList<>();


        Question question;

        if (session.getAttribute("questions")==null){
            question = quizQuestionService.findById(1L).get();
        }else {
          question =  (Question) session.getAttribute("questions");
          question =  quizQuestionService.findById(question.getId()+1).get();
        }



//        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/questions/questions.txt"));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            while (line != null) {
//                sb.append(line);
//                sb.append("\n");
//                line = br.readLine();
//
//                if (line.contains("Q")){
//                    question.setQuestion(line);
//                }else if (line.contains("A1")){
//                    question.setAnswer1(line);
//                }else if (line.contains("A2")){
//                    question.setAnswer2(line);
//                }else if (line.contains("A3")){
//                    question.setAnswer3(line);
//                }else if (line.contains("A4")){
//                    question.setAnswer4(line);
//                }else if (line.contains("CorrectAnswer: ")&&line.contains("A1")){
//                    question.setCorrectAnswer(question.getAnswer1());
//                }else if (line.contains("CorrectAnswer: ")&&line.contains("A2")){
//                    question.setCorrectAnswer(question.getAnswer2());
//                }else if (line.contains("CorrectAnswer: ")&&line.contains("A3")){
//                    question.setCorrectAnswer(question.getAnswer3());
//                }else if (line.contains("CorrectAnswer: ")&&line.contains("A4")){
//                    question.setCorrectAnswer(question.getAnswer4());
//                }
        questionList.add(question);
//        quizQuestionService.save(question);
        room.setQuestions(questionList);
        model.addAttribute("room", room);
        model.addAttribute("questions", room.getQuestions());
        session.setAttribute("questions",question);


//                session.setAttribute("quizId",question.);
        return "PlayingPage";
//            }
//            return sb.toString();
//        } finally {
//            br.close();
//        }
    }


}
