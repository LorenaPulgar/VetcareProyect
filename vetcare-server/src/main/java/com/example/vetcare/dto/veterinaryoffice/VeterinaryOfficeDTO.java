package com.example.vetcare.dto.veterinaryoffice;

import com.example.vetcare.dto.user.UserDto;

public record VeterinaryOfficeDTO(Long id, UserDto user, String address, String name) {
}
