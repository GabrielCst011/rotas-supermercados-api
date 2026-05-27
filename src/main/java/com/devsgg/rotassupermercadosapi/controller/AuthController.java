package com.devsgg.rotassupermercadosapi.controller;

import com.devsgg.rotassupermercadosapi.auth.AuthService;
import com.devsgg.rotassupermercadosapi.dto.LoginRequestDTO;
import com.devsgg.rotassupermercadosapi.dto.LoginResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request){
        return authService.login(request);
    }

}
