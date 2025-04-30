package com.myconstruccion.auth.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    // Constructor, getters y setters
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
}
