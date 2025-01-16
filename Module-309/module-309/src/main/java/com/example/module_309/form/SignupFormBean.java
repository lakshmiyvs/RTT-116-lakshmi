package com.example.module_309.form;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormBean {

    @Email(message = "Username already exists.")
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Full Name is required")
    private String fullname;
}
