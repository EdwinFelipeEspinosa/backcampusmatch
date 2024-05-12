package com.app.usuarios.data;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.usuarios.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	public Optional<User> findById(Long id);
}
