package com.example.vetcare.dto.appointment;

import com.example.vetcare.dto.petowner.PetOwnerDTO;
import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeDTO;

import java.time.LocalDateTime;

public record AppointmentToSaveDTO(PetOwnerDTO petOwner, VeterinaryOfficeDTO veterinaryOffice, LocalDateTime date) {
}
