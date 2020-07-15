package com.vladimirkomlev.qualitylabchallenge.model;

public class Credentials {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public Credentials withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Credentials withPassword(String password) {
        this.password = password;
        return this;
    }
}
