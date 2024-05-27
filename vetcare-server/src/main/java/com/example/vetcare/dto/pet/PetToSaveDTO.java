package com.example.vetcare.dto.pet;

import com.example.vetcare.dto.petowner.PetOwnerDTO;

public record PetToSaveDTO(String name, String sex, Integer age, PetOwnerDTO petOwner) {
}
