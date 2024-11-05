package com.dream.drive.model;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity(name = "app_user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String password;
    

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();

    // Constructors, getters, and setters
    public User() {
        roles.add("USER"); // Default role for new users
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        roles.add("USER"); // Default role
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

   
}
