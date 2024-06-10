package com.example.vetcare.auth;

public record AuthResponse(String token, Long userId, Long petOwnerId) {
}
