package com.app.usuarios.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "intereses")
public class Interes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_interes")
    private Long id;

    @Column(name = "nom_interes")
    private String nombre;

    @Column(name = "img_interes")
    private String imagen;

    // Constructor sin argumentos requerido por JPA
    public Interes() {
    }

    // Constructor con todos los argumentos
    public Interes(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
	

    // Constructores, getters y setters
    
}