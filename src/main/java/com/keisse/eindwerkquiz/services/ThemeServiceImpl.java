package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Theme;
import com.keisse.eindwerkquiz.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService{

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public void save(Theme theme) {
        themeRepository.save(theme);
    }

    @Override
    public Optional<Theme> findById(Long id) {
        return themeRepository.findById(id);
    }


    @Override
    public void deleteById(Long id) {
        themeRepository.deleteById(id);
    }
}
