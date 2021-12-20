package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.UserScore;
import com.keisse.eindwerkquiz.repository.UserScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserScoreServiceImpl implements  UserScoreService{

    @Autowired
    private UserScoreRepository userScoreRepository;


    @Override
    public List<UserScore> findAll() {
        return userScoreRepository.findAll();
    }

    @Override
    public void save(UserScore userScore) {
     userScoreRepository.save(userScore);
    }

    @Override
    public Optional<UserScore> findById(Long id) {
        return userScoreRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userScoreRepository.deleteById(id);
    }
}
