package com.example.vetcare.repository;

import com.example.vetcare.entity.Appointment;
import com.example.vetcare.entity.PetOwner;
import com.example.vetcare.entity.VeterinaryOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByVeterinaryOffice(VeterinaryOffice veterinaryOffice);

    List<Appointment> findAppointmentByPetOwner(PetOwner petOwner);
}
