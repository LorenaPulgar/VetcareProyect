package com.example.vetcare.controller;

import com.example.vetcare.dto.veterinaryoffice.VeterinaryOfficeDTO;
import com.example.vetcare.service.VeterinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class VeterinaryController {
    private final VeterinaryService veterinaryService;

    @RequestMapping(value = "/veterinary", method = RequestMethod.GET)
    public ResponseEntity<List<VeterinaryOfficeDTO>> index() {
        return ResponseEntity.ok(veterinaryService.getAll());
    }

}
