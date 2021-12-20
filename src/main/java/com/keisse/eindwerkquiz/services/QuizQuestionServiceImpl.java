package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.QuizQuestion;
import com.keisse.eindwerkquiz.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService{

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Override
    public List<QuizQuestion> findAll() {
        return quizQuestionRepository.findAll();
    }

    @Override
    public void save(QuizQuestion quizQuestion) {
    quizQuestionRepository.save(quizQuestion);
    }

    @Override
    public Optional<QuizQuestion> findById(Long id) {
        return quizQuestionRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    quizQuestionRepository.deleteById(id);
    }
}
