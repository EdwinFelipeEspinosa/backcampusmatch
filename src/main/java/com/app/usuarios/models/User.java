package com.app.usuarios.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
	@SequenceGenerator(name = "seq_users", sequenceName = "SEQ_USERS", allocationSize = 1)
	private long id;
	private String nombre;
	private String usuario;
	private String email;
	private String password;
	private String imagen;
	private String imagen1;
	private String imagen2;
	private String imagen3;
	private String imagen4;
	private String descripcion;
	@Column(name = "IMAGEASSET")
	private String imageAsset;
	private String distance;

	public User() {
	}
	

	public User(long id, String nombre, String usuario, String email, String password, String imagen, String imagen1,
			String imagen2, String imagen3, String imagen4, String descripcion, String imageAsset, String distance) {
	
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.imagen = imagen;
		this.imagen1 = imagen1;
		this.imagen2 = imagen2;
		this.imagen3 = imagen3;
		this.imagen4 = imagen4;
		this.descripcion = descripcion;
		this.imageAsset = imageAsset;
		this.distance = distance;
	}

	public User(long id, String nombre, String usuario, String email, String password, String imagen, String imagen1,
			String imagen2, String imagen3, String imagen4, String descripcion) {
	
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.imagen = imagen;
		this.imagen1 = imagen1;
		this.imagen2 = imagen2;
		this.imagen3 = imagen3;
		this.imagen4 = imagen4;
		this.descripcion = descripcion;
	}

	public User(long id, String nombre, String email, String password, String usuario,String imagen, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.usuario = usuario;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}
	

	public User(long id, String nombre, String usuario, String email, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}

	public String getImagen1() {
		return imagen1;
	}

	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}


	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getImagen3() {
		return imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public String getImagen4() {
		return imagen4;
	}

	public void setImagen4(String imagen4) {
		this.imagen4 = imagen4;
	}

	public String getImageAsset() {
		return imageAsset;
	}

	public void setImageAsset(String imageAsset) {
		this.imageAsset = imageAsset;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
}
