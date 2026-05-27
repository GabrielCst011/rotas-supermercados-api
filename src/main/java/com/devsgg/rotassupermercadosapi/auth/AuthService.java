package com.devsgg.rotassupermercadosapi.auth;

import com.devsgg.rotassupermercadosapi.dto.LoginRequestDTO;
import com.devsgg.rotassupermercadosapi.dto.LoginResponseDTO;
import com.devsgg.rotassupermercadosapi.entity.User;
import com.devsgg.rotassupermercadosapi.exception.InvalidCredentialsException;
import com.devsgg.rotassupermercadosapi.repository.UserRepository;
import com.devsgg.rotassupermercadosapi.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponseDTO(token);
    }
}