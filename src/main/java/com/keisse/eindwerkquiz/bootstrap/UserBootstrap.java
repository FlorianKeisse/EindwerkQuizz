package com.keisse.eindwerkquiz.bootstrap;

import com.keisse.eindwerkquiz.models.Punishment;
import com.keisse.eindwerkquiz.models.Question;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import com.keisse.eindwerkquiz.services.PunishmentService;
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
    PunishmentService punishmentService;

    @SneakyThrows
    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


//        Question question = new Question();
//
//        question.setQuestion("In which book does 'Sancho Panza' appear?");
//        question.setAnswer3("The Diary of a Chambermaid");
//        question.setAnswer2("Foucault's Pendulum");
//        question.setAnswer1("Adventures of Huckleberry Finn");
//        question.setAnswer4("Don Quixote");
//        question.setCorrectAnswer("4");
//
//        quizQuestionService.save(question);
//
//
//        Question question2 = new Question();
//
//        question2.setQuestion("In which continent would you find the Ob river?");
//        question2.setAnswer1("Asia");
//        question2.setAnswer2("Europe");
//        question2.setAnswer3("Africa");
//        question2.setAnswer4("Autralasia");
//        question2.setCorrectAnswer("1");
//
//        quizQuestionService.save(question2);
//
//        Question question3 = new Question();
//
//        question3.setQuestion("Which actor played the role of Luke Skywalker in Star Wars?");
//        question3.setAnswer1("Harrison Ford");
//        question3.setAnswer2("Ewan McGregor");
//        question3.setAnswer3("Mark Hamill");
//        question3.setAnswer4("James Earl Jones");
//        question3.setCorrectAnswer("3");
//
//        quizQuestionService.save(question3);

//        Punishment punishment = new Punishment();
////
//        punishment.setPunishmentTask("Seems you got lucky this time. No sips for you. (unless you want)");
//        punishment.setPunishment1("Drink 1 sip of your liqour");
//        punishment.setPunishment2("Depending on what drink you have, down it. otherwise take 3 sips.");
//        punishment.setPunishment3("Drink 3 sips wazaaaaaaaaa");
//        punishment.setPunishment4("Seems you got lucky this time. No sips for you. (unless you want)");
//        punishment.setPunishment5("Seems you got even more lucky, let another person drink 1-2 sips");

//        punishmentService.save(punishment);
    }

    // END QUIZ SET 1 //


}

