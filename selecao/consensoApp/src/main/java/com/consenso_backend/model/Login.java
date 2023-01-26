package com.consenso_backend.model;

import jakarta.validation.constraints.Email;
import lombok.Data;


@Data
public class Login {

    @Email
    private String email;

    private String senha;

    
}
