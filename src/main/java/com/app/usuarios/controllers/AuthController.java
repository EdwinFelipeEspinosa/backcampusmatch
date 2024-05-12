package com.app.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.usuarios.models.LoginRequest;
import com.app.usuarios.models.User;
import com.app.usuarios.services.UserService;

@RestController
public class AuthController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/api-user/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginRequest loginRequest) {
        try {
            // Obtener el usuario por su email (suponiendo que el email sea único)
            User usuario = userService.obtenerUsuarioPorEmail(loginRequest.getEmail());
            
            // Verificar si el usuario existe y si la contraseña es válida
            if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
                // Si las credenciales son válidas, puedes devolver el usuario o algún token de sesión
                return ResponseEntity.ok(usuario);
            } else {
                // Si las credenciales no son válidas, devolver un mensaje de error
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        } catch (Exception e) {
            // Capturar cualquier excepción que ocurra durante el inicio de sesión
            String mensajeError = "Error al iniciar sesión: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

}
