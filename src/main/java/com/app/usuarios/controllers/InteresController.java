package com.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.usuarios.models.Interes;
import com.app.usuarios.services.InteresService;

@RestController
@RequestMapping("/api/intereses")
public class InteresController {

    private final InteresService interesService;

    @Autowired
    public InteresController(InteresService interesService) {
        this.interesService = interesService;
    }

    @GetMapping
    public List<Interes> getAllIntereses() {
        return interesService.getAllIntereses();
    }
}