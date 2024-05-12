package com.app.usuarios.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.usuarios.models.User;
import com.app.usuarios.services.UserService;


@RestController
@RequestMapping("/api-user")
public class UserController {
		
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> getAllPersonas() {
		return userService.getAllPersonas();
	}
	
	@GetMapping("/userbyid")
	public User getAllPerson(@RequestParam("id") Long id) {
		return userService.getById(id);
	}
	
	@PostMapping("/setuser")
	public ResponseEntity<?> crearUsuario(@RequestBody User user) {
	    try {
	        User usuarioCreado = userService.insertarUsuario(user);
	        return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
	    } catch (Exception e) {
	        // Capturar cualquier excepción que ocurra durante la inserción
	        String mensajeError = "Error al crear el usuario: " + e.getMessage();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
	    }
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> subir(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		User actual=userService.getById(id);
		Map<String, Object> response=new HashMap<>();
		System.out.println("id: " + id);
		System.out.println("archivo: " + archivo);
		String nombreArchivo = archivo.getOriginalFilename();
		if(!archivo.isEmpty()) {
			String nombre= actual.getId() + "_" + actual.getUsuario() + "." + nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1);   //archivo.getOriginalFilename().replace(" ","");
			java.nio.file.Path rutaArchivo=Paths.get("images").resolve(nombre).toAbsolutePath();
			System.out.println(nombre);
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			}
			catch(IOException e) {
				response.put("Mensaje", "Error al subir la imagen");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			};
			String imagenAnterior=actual.getImagen();
			if(imagenAnterior!=null && imagenAnterior.length()>0) {
				java.nio.file.Path rutaImagen=Paths.get("images").resolve(imagenAnterior).toAbsolutePath();
				File archivoAnterior=rutaImagen.toFile();
				archivoAnterior.delete();
			}
			actual.setImagen(nombre);
			userService.insertarUsuario(actual);
			response.put("user", actual);
			response.put("Mensaje", "Se subio la imagen");
		}
		return new ResponseEntity<Map<String,Object>>
		(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/getimg/{nombrefoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombrefoto){
		System.out.println(nombrefoto);
		java.nio.file.Path rutaImagen=Paths.get("images").resolve(nombrefoto).toAbsolutePath();
		Resource recurso=null;
		try {
			recurso=new UrlResource(rutaImagen.toUri());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		HttpHeaders cabecera=new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename\""+recurso.getFilename());
		return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
	}
	
}
