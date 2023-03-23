package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotNull
    @Size(min = 1, max = 32)
    private String username;

    @NotNull
    @Size(min = 1, max = 32)
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
