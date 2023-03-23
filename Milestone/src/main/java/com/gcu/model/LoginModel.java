package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

    // @NotNull
    // @Size(min = 1, max = 32)
    private String email;

    // @NotNull
    // @Size(min = 1, max = 32)
    private String password;

    public String getEmail() {
        return email;
    }
    public void setEmail (String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
