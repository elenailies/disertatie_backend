package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private String email;
    private String role;
    private String menuRole; // New field added for menu role

    private boolean enabled; // New field added earlier

    // Default constructor
    public User(){}

    // Constructor with all fields, including menuRole
    public User(String username, String password, String email, String role, String name, String surname, String phone, boolean enabled, String menuRole){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.enabled = enabled; // Initialize the new field
        this.menuRole = menuRole; // Initialize menuRole
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMenuRole() {
        return menuRole;
    }
    public void setMenuRole(String menuRole) {
        this.menuRole = menuRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", menuRole='" + menuRole + '\'' +  // Include menuRole in toString
                ", enabled=" + enabled +
                '}';
    }
}
