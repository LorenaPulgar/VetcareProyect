package com.example.vetcare.dto.pet;

import com.example.vetcare.entity.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetDTO petToPetDTO(Pet pet);
    Pet petDTOToPet(PetDTO petDTO);
    Pet petSaveDTOToPet(PetToSaveDTO petToSaveDTO);

}
