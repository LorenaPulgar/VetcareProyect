package com.example.vetcare.dto.petowner;

import com.example.vetcare.entity.PetOwner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface PetOwnerMapper {
    PetOwnerDTO petOwnerToPetOwnerDTO(PetOwner petOwner);
    PetOwner petOwnerDTOToPetOwner(PetOwnerDTO petOwnerDTO);
    PetOwner petOwnerSaveDTOToPetOwner(PetOwnerToSaveDTO petOwnerToSaveDTO);
}
