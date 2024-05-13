package com.app.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.usuarios.data.InteresUsuarioRepository;
import com.app.usuarios.models.InteresUsuario;

@Service
public class InteresUsuarioService {

    private final InteresUsuarioRepository interesUsuarioRepository;

    @Autowired
    public InteresUsuarioService(InteresUsuarioRepository interesUsuarioRepository) {
        this.interesUsuarioRepository = interesUsuarioRepository;
    }

    public InteresUsuario agregarInteresUsuario(InteresUsuario interesUsuario) {
        return interesUsuarioRepository.save(interesUsuario);
    }
}
