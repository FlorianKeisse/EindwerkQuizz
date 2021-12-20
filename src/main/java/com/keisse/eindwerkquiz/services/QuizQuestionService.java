package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.QuizQuestion;

import java.util.List;
import java.util.Optional;

public interface QuizQuestionService {
    List<QuizQuestion> findAll();

    void save(QuizQuestion quizQuestion);

    Optional<QuizQuestion> findById(Long id);

    void deleteById(Long id);
}
