package com.example.vetcare.repository;

import com.example.vetcare.entity.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

}
