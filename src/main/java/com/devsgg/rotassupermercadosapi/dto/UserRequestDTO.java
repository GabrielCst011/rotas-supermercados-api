package com.devsgg.rotassupermercadosapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDTO {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private  String password;

    @NotBlank(message = "Role is required")
    private String role;

    public UserRequestDTO() {

    }

}
