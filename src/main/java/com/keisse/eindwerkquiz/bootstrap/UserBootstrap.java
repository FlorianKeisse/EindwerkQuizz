package com.keisse.eindwerkquiz.bootstrap;

import com.keisse.eindwerkquiz.models.Question;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    QuizQuestionService quizQuestionService;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        // QUIZ SET 1 //
        Question quizQuestion = new Question();

        quizQuestion.setQuestion("How big is the mount everest?");

        quizQuestion.setAnswer1("very big");
        quizQuestion.setAnswer2("very small");
        quizQuestion.setAnswer3("very thicc");
        quizQuestion.setAnswer4("very smoll");

        quizQuestion.setCorrectAnswer(quizQuestion.getAnswer3());
        quizQuestionService.save(quizQuestion);


      // END QUIZ SET 1 //



    }
}
