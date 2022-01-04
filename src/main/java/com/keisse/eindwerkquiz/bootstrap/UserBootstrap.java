package com.keisse.eindwerkquiz.bootstrap;

import com.keisse.eindwerkquiz.models.Question;
import com.keisse.eindwerkquiz.models.UserScore;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import com.keisse.eindwerkquiz.services.UserScoreService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    QuizQuestionService quizQuestionService;

    @Autowired
    UserScoreService userScoreService;

    @SneakyThrows
    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        Question question = new Question();

        question.setQuestion("how big is mt Fuji?");
        question.setAnswer1("very big");
        question.setAnswer2("3.776m");
        question.setAnswer3("2.678m");
        question.setAnswer4("4.443m");
        question.setCorrectAnswer("2");

        quizQuestionService.save(question);


        Question question2 = new Question();

        question2.setQuestion("how big is mt Hotaka");
        question2.setAnswer1("very big");
        question2.setAnswer2("3.190m");
        question2.setAnswer3("3.668m");
        question2.setAnswer4("3.891m");
        question2.setCorrectAnswer("1");

        quizQuestionService.save(question2);

        Question question3 = new Question();

        question3.setQuestion("how big is mt Kita?");
        question3.setAnswer1("1.234m");
        question3.setAnswer2("3.193m");
        question3.setAnswer3("3.133m");
        question3.setAnswer4("4.666m");
        question3.setCorrectAnswer("2");

        quizQuestionService.save(question3);

        UserScore userScore = new UserScore();

        userScore.setPunishment("Drink 2 sips of your liquor");
        userScore.setPunishment1("Drink 1 sip of your liqour");
        userScore.setPunishment2("Depending on what drink you have, down it. otherwise take 3 sips.");
        userScore.setPunishment3("Drink 3 sips wazaaaaaaaaa");
        userScore.setPunishment4("Seems you got lucky this time. No sips for you. (unless you want)");
        userScore.setPunishment5("Seems you got even more lucky, let another person drink 1-2 sips");

        userScoreService.save(userScore);
    }

    // END QUIZ SET 1 //


}

