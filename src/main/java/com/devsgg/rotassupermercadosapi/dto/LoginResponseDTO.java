package com.devsgg.rotassupermercadosapi.dto;

import lombok.Getter;

@Getter
public class LoginResponseDTO {

    private String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

}