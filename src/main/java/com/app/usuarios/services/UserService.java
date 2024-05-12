package com.app.usuarios.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.usuarios.data.UserRepository;
import com.app.usuarios.models.User;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllPersonas() {
		return userRepository.findAll();
	}

	public User getById(long id) {
		return userRepository.findById(id).orElse(new User());
	}
	

    public User insertarUsuario(User user) {
        return userRepository.save(user);
    }
    
    public User obtenerUsuarioPorEmail(String email) {
        // Realizar una consulta a la base de datos para obtener el usuario por su email
        Optional<User> usuarioOptional = userRepository.findByEmail(email);
        // Verificar si el usuario existe y devolverlo
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            // Si no se encuentra ningún usuario con el email dado, devolver null o lanzar una excepción según tu lógica de negocio
            return null;
        }
    }
    
    public static String saveImage(MultipartFile file) {
        try {
            // Generar un nombre único para la imagen
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            // Guardar la imagen en el servidor
            file.transferTo(new File("/ruta/donde/guardar/" + fileName));
            // Devolver la URL de la imagen guardada
            return "http://tudominio.com/imagenes/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la imagen");
        }
    }

}
