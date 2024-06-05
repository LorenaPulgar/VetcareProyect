package com.example.vetcare.service;

import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeDTO;
import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeMapper;
import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeToSaveDTO;
import com.example.vetcare.repository.VeterinaryOfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeterinaryService {
    private final VeterinaryOfficeRepository veterinaryOfficeRepository;
    private final VeterinaryOfficeMapper veterinaryOfficeMapper;

    public List<VeterinaryOfficeDTO> getAll() {
        var veterinaries = veterinaryOfficeRepository.findAll();
        var veterinariesDTO = veterinaries.stream()
                .map(veterinaryOfficeMapper::veterinaryOfficeToVeterinaryOfficeDTO)
                .collect(Collectors.toList());
        return veterinariesDTO;
    }
}
