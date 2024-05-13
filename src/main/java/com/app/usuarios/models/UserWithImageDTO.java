package com.app.usuarios.models;

import jakarta.annotation.Resource;

public class UserWithImageDTO {
    private User user;
    private Resource image;

    public UserWithImageDTO(User user, Resource image) {
        this.user = user;
        this.image = image;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resource getImage() {
		return image;
	}

	public void setImage(Resource image) {
		this.image = image;
	}


    
    

    // Getters y setters
}
