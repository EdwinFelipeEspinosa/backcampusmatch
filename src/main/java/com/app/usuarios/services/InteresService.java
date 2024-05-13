package com.app.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.usuarios.data.InteresRepository;
import com.app.usuarios.models.Interes;

@Service
public class InteresService {

    private final InteresRepository interesRepository;

    @Autowired
    public InteresService(InteresRepository interesRepository) {
        this.interesRepository = interesRepository;
    }

    public List<Interes> getAllIntereses() {
        return interesRepository.findAll();
    }
}