package com.example.vetcare.dto.veterinaryoffice;

import com.example.vetcare.dto.user.UserInfoDto;

public record VeterinaryOfficeDTO(Long id, UserInfoDto user, String adress) {
}
