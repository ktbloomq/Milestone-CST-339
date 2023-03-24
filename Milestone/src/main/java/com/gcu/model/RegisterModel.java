package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterModel {
    @NotNull(message = "enter first name")
    @Size(max = 32, message = "first name is too long")
    private String firstName;

    @NotNull(message = "enter last name")
    @Size(max = 32, message = "last name is too long")
    private String lastName;

    @NotNull(message = "enter email")
    @Size(max = 32, message = "email is too long")
    private String email;
    
    @NotNull(message = "enter password")
    @Size(min = 10, max = 32, message = "password must be between 10 and 32 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    
}