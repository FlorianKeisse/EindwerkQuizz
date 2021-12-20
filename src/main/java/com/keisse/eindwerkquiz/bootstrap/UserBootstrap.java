package com.keisse.eindwerkquiz.bootstrap;

import com.keisse.eindwerkquiz.models.QuizQuestion;
import com.keisse.eindwerkquiz.models.Room;
import com.keisse.eindwerkquiz.models.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        // QUIZ SET 1 //
        QuizQuestion quizQuestion = new QuizQuestion();

        quizQuestion.setQuestion("How big is the mount everest?");

        quizQuestion.setAnswer1("very big");
        quizQuestion.setAnswer2("very small");
        quizQuestion.setAnswer3("very thicc");
        quizQuestion.setAnswer4("very smoll");

        quizQuestion.setCorrectAnswer(quizQuestion.getAnswer3());

      // END QUIZ SET 1 //



    }
}
