package com.example.vetcare.repository;

import com.example.vetcare.entity.PetOwner;
import com.example.vetcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
    PetOwner findPetOwnerByUser(User user);
}
