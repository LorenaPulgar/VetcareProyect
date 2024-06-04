package com.example.vetcare.dto.veterinaryoffice;

import com.example.vetcare.dto.user.UserDto;

public record VeterinaryOfficeToSaveDTO(UserDto user, String name, String address) {
}
