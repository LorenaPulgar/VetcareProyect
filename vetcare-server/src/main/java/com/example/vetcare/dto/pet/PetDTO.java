package com.example.vetcare.dto.pet;

import com.example.vetcare.dto.petowner.PetOwnerDTO;

public record PetDTO(Long id, String name, String sex, Integer age, PetOwnerDTO petOwner) {
}
