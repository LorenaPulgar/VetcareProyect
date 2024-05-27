package com.example.vetcare.dto.appointment;

import com.example.vetcare.dto.petowner.PetOwnerDTO;
import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeDTO;

public record AppointmentToSaveDTO(PetOwnerDTO petOwner, VeterinaryOfficeDTO veterinaryOffice, String status) {
}
