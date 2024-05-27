package com.example.vetcare.dto.petowner;

import com.example.vetcare.dto.pet.PetDTO;
import com.example.vetcare.dto.user.UserInfoDto;

import java.util.List;

public record PetOwnerDTO(Long id, UserInfoDto user, List<PetDTO> pets) {
}
