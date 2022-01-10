package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Punishment;
import com.keisse.eindwerkquiz.repository.UserScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PunishmentServiceImpl implements PunishmentService {

    @Autowired
    private UserScoreRepository userScoreRepository;


    @Override
    public List<Punishment> findAll() {
        return userScoreRepository.findAll();
    }

    @Override
    public void save(Punishment punishment) {
     userScoreRepository.save(punishment);
    }

    @Override
    public Optional<Punishment> findById(Long id) {
        return userScoreRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userScoreRepository.deleteById(id);
    }
}
