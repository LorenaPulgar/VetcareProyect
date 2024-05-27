package com.example.vetcare.dto.appointment;

import com.example.vetcare.dto.petowner.PetOwnerDTO;
import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeDTO;

public record AppointmentDTO(Long id, PetOwnerDTO petOwner, VeterinaryOfficeDTO veterinaryOffice, String status) {
}
