package com.example.vetcare.dto.veterinaryoffice;

import com.example.vetcare.dto.user.UserInfoDto;

public record VeterinaryOfficeToSaveDTO(UserInfoDto user, String adress) {
}
