package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {

    List<Theme> findAll();

    void save(Theme theme);

    Optional<Theme> findById(Long id);

    void deleteById(Long id);
}
