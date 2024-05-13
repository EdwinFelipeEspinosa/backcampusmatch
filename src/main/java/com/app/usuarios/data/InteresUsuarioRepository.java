package com.app.usuarios.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.usuarios.models.InteresUsuario;

@Repository
public interface InteresUsuarioRepository extends JpaRepository<InteresUsuario, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
