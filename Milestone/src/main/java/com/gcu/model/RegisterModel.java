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
    
    @NotNull(message = "enter address")
    @Size(min = 1, max = 64, message = "address must be between 1 and 64 characters")
    private String address;
    
    @NotNull(message = "enter phone")
    @Size(min = 1, max = 64, message = "phone number must be between 10 and 11 characters")
    private String phone;

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
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
