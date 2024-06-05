package com.example.vetcare.repository;

import com.example.vetcare.entity.User;
import com.example.vetcare.entity.VeterinaryOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinaryOfficeRepository extends JpaRepository<VeterinaryOffice, Long> {
    VeterinaryOffice findVeterinaryOfficeByUser(User user);
}
