package com.example.vetcare.auth;

import com.example.vetcare.enums.Role;
import com.example.vetcare.exception.AlreadyExistException;
import com.example.vetcare.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.vetcare.entity.User;
import com.example.vetcare.jwt.JwtService;
import com.example.vetcare.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .phoneNumber(request.phoneNumber())
                .role(Role.USER)
                .build();

        try {
            userRepository.save(user);

        } catch (DataIntegrityViolationException err) {
            throw new AlreadyExistException("This email is already taken");
        }

        return new AuthResponse(jwtService.getToken(user));
    }

    public AuthResponse login(LoginRequest request) {
        UserDetails userDetails = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        String token = jwtService.getToken(userDetails);
        return new AuthResponse(token);
    }
}
