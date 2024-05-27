package com.example.vetcare.dto.veterinaryoffice;


import com.example.vetcare.entity.VeterinaryOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeterinaryOfficeMapper {
    VeterinaryOfficeDTO veterinaryOfficeToVeterinaryOfficeDTO(VeterinaryOffice veterinaryOffice);
    VeterinaryOffice veterinaryOfficeDTOToVeterinaryOffice(VeterinaryOfficeDTO veterinaryOfficeDTO);
    VeterinaryOffice veterinaryOfficeSaveDTOToVeterinaryOffice(VeterinaryOfficeToSaveDTO veterinaryOfficeToSaveDTO);
}
