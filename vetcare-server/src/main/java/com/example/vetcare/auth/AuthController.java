package com.example.vetcare.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthResponse> register(@RequestParam(value = "isVeterinary", defaultValue = "false", required = false) Boolean isVeterinary, @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request, isVeterinary));
    }

    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
