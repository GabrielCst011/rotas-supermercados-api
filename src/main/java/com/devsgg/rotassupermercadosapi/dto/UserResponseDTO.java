package com.devsgg.rotassupermercadosapi.dto;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String username;
    private String role;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name, String username, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}