package com.app.usuarios.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.usuarios.models.Interes;

public interface InteresRepository extends JpaRepository<Interes, Long> {
}
