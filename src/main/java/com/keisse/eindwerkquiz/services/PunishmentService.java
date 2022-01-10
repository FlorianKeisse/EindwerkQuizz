package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Punishment;

import java.util.List;
import java.util.Optional;

public interface PunishmentService {

    List<Punishment> findAll();

    void save(Punishment punishment);

    Optional<Punishment> findById(Long id);

    void deleteById(Long id);
}
