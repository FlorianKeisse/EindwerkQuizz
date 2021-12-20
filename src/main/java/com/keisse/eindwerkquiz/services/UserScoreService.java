package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.UserScore;

import java.util.List;
import java.util.Optional;

public interface UserScoreService {

    List<UserScore> findAll();

    void save(UserScore userScore);

    Optional<UserScore> findById(Long id);

    void deleteById(Long id);
}
