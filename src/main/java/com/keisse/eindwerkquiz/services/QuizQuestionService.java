package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Question;

import java.util.List;
import java.util.Optional;

public interface QuizQuestionService {
    List<Question> findAll();

    void save(Question quizQuestion);

    Optional<Question> findById(Long id);

    void deleteById(Long id);
}
