package com.fennec.freelanceproject.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegistrationForm {

    private String username;
    private String password;
    private String role;
}
