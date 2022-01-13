package com.keisse.eindwerkquiz.bootstrap;


import com.keisse.eindwerkquiz.models.Punishment;
import com.keisse.eindwerkquiz.models.Question;
import com.keisse.eindwerkquiz.services.QuizQuestionService;
import com.keisse.eindwerkquiz.services.PunishmentService;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Random;


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

        try{
            final String diff="difficulty",question="question",correct="correct_answer",incorrect="incorrect_answers",category="category",type="type";
            URL url = new URL("https://opentdb.com/api.php?amount=50&category=15&difficulty=medium&type=multiple");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            String response = new String(url.openStream().readAllBytes(), StandardCharsets.UTF_8);

            JSONObject responseJSON= new JSONObject(response);
            JSONArray questionArr = (JSONArray) responseJSON.get("results");

            for (int i = 0; i < 3; i++) {
                JSONObject questionJSONObject = questionArr.getJSONObject(i);
                String questions = (String) questionJSONObject.get(question);
                String correctAnswer = (String) questionJSONObject.get(correct);
                String incorrectAnswers = questionJSONObject.get(incorrect).toString();

                incorrectAnswers = incorrectAnswers.replaceAll(",","@");
                String [] incorrect1 = incorrectAnswers.split("@");

                Question qforDatabase = new Question();

                System.out.println(questions);
                System.out.println(correctAnswer);

//                for (String a : incorrect1){ //todo vragen toevoegen zonder dubbels
//                    String replaceString  = a.replaceAll("[^a-zA-Z0-9]"," ");
//                    System.out.println(replaceString);
//
//                    qforDatabase.setQuestion(questions);
//
//                    if (qforDatabase.getAnswer3()==null ){
//                    qforDatabase.setAnswer3(replaceString);
//                    } else if (qforDatabase.getAnswer2()==null){
//                        qforDatabase.setAnswer2(replaceString);
//                    } else if (qforDatabase.getAnswer4()==null) {
//                        qforDatabase.setAnswer4(replaceString);
//                    }
//                }
//                if (qforDatabase.getAnswer1()==null){
//                    qforDatabase.setAnswer1(correctAnswer);
//                    qforDatabase.setCorrectAnswer("1");
//                }
//                quizQuestionService.save(qforDatabase);


//                System.out.println(questions);
//                System.out.println(replaceString);
//                System.out.println(correctAnswer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        Punishment punishment = new Punishment();
//
//        punishment.setPunishmentTask("Drink 1 sip of your liqour");
//
//        punishmentService.save(punishment);

    }

//        punishment.setPunishment1("Drink 1 sip of your liqour");
//        punishment.setPunishment2("Depending on what drink you have, down it. otherwise take 3 sips.");
//        punishment.setPunishment3("Drink 3 sips wazaaaaaaaaa");
//        punishment.setPunishment4("Seems you got lucky this time. No sips for you. (unless you want)");
//        punishment.setPunishment5("Seems you got even more lucky, let another person drink 1-2 sips");

}

