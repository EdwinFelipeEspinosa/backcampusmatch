package com.app.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.usuarios.models.InteresUsuario;
import com.app.usuarios.services.InteresUsuarioService;

@RestController
@RequestMapping("/api/intereses")
public class InteresUsuarioController {

    private final InteresUsuarioService interesUsuarioService;

    @Autowired
    public InteresUsuarioController(InteresUsuarioService interesUsuarioService) {
        this.interesUsuarioService = interesUsuarioService;
    }

    // Métodos de controlador para insertar, actualizar, borrar y consultar InteresUsuario
    // Puedes definir las rutas y los métodos que necesites según los requisitos de tu aplicación
    @PostMapping("/agregar")
    public ResponseEntity<InteresUsuario> agregarInteresUsuario(@RequestBody InteresUsuario interesUsuario) {
        InteresUsuario nuevoInteresUsuario = interesUsuarioService.agregarInteresUsuario(interesUsuario);
        return new ResponseEntity<>(nuevoInteresUsuario, HttpStatus.CREATED);
    }}	
