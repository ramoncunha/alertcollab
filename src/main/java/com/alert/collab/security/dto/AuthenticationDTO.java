package com.alert.collab.security.dto;

import javax.validation.constraints.NotEmpty;

public class AuthenticationDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String senha;

    public AuthenticationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
