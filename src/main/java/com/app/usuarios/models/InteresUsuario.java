package com.app.usuarios.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_interes")
public class InteresUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_interes_sc")
	@SequenceGenerator(name = "usuario_interes_sc", sequenceName = "USUARIO_INTERES_SC", allocationSize = 1)
    private Long id;

    @Column(name = "id_usuario") // Cambiar a @Column para que pueda aceptar directamente el ID
    private Long idUsuario; // Cambiar el tipo de User a Long

    @Column(name = "id_interes") // Cambiar a @Column para que pueda aceptar directamente el ID
    private Long idInteres; // Cambiar el tipo de Interes a Long

    // Constructor sin argumentos requerido por JPA
    public InteresUsuario() {
    }

    // Constructor con los IDs de usuario e interes
    public InteresUsuario(Long idUsuario, Long idInteres) {
        this.idUsuario = idUsuario;
        this.idInteres = idInteres;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Long idInteres) {
        this.idInteres = idInteres;
    }
    
    // Opcionalmente, puedes agregar métodos para convertir entre InteresUsuario y sus IDs correspondientes
    
}
