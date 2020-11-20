package com.alert.collab.security.dto;

import javax.validation.constraints.NotEmpty;

public class AuthenticationDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public AuthenticationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
