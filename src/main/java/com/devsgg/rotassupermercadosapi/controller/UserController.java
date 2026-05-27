package com.devsgg.rotassupermercadosapi.controller;

import com.devsgg.rotassupermercadosapi.dto.UserRequestDTO;
import com.devsgg.rotassupermercadosapi.entity.User;
import com.devsgg.rotassupermercadosapi.service.UserService;
import com.devsgg.rotassupermercadosapi.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO request) {

        User user = new User();

        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userService.createUser(user);
    }
}