package com.example.vetcare.service;

import com.example.vetcare.dto.appointment.AppointmentDTO;
import com.example.vetcare.dto.appointment.AppointmentMapper;
import com.example.vetcare.dto.appointment.AppointmentToSaveDTO;
import com.example.vetcare.entity.Appointment;
import com.example.vetcare.entity.VeterinaryOffice;
import com.example.vetcare.enums.AppointmentStatus;
import com.example.vetcare.enums.Role;
import com.example.vetcare.exception.AlreadyExistException;
import com.example.vetcare.exception.ResourceNotFoundException;
import com.example.vetcare.repository.AppointmentRepository;
import com.example.vetcare.repository.PetOwnerRepository;
import com.example.vetcare.repository.UserRepository;
import com.example.vetcare.repository.VeterinaryOfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final UserRepository userRepository;
    private final PetOwnerRepository petOwnerRepository;
    private final VeterinaryOfficeRepository veterinaryOfficeRepository;

    public AppointmentDTO create(AppointmentToSaveDTO appointment) {
        var newAppointment = appointmentMapper.appointmentSaveDTOToAppointment(appointment);

        var veterinaryOffice = VeterinaryOffice.builder().id(appointment.veterinaryOffice().id()).build();

        var appointments = appointmentRepository.findAppointmentByVeterinaryOffice(veterinaryOffice);

        boolean occupied = appointments.stream()
                .anyMatch(app -> app.getDate().equals(appointment.date()));

        if (occupied) {
            throw new AlreadyExistException("This veterinary has an appointment in that date already");
        }

        // When a new appointment is crated then its state is PENDING
        newAppointment.setStatus(AppointmentStatus.PENDING);

        var savedAppointment = appointmentRepository.save(newAppointment);
        return appointmentMapper.appointmentToAppointmentDTO(savedAppointment);
    }

    public List<AppointmentDTO> getAll() {
        var userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        List<Appointment> appointments;

        if (user.getRole().equals(Role.PET_OWNER)) {
            var petOwner = petOwnerRepository.findPetOwnerByUser(user);
            appointments = appointmentRepository.findAppointmentByPetOwner(petOwner);
        } else {
            var veterinary = veterinaryOfficeRepository.findVeterinaryOfficeByUser(user);
            appointments = appointmentRepository.findAppointmentByVeterinaryOffice(veterinary);
        }

        return appointments.stream()
                .map(appointmentMapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO cancelAppointment(AppointmentDTO appointmentDTO) {
        var appointment = appointmentRepository.findById(appointmentDTO.id())
                .orElseThrow(() -> new ResourceNotFoundException("There is no appointments with id provided"));

        appointment.setStatus(AppointmentStatus.CANCELLED);

        var savedAppointment = appointmentRepository.save(appointment);

        return appointmentMapper.appointmentToAppointmentDTO(savedAppointment);
    }
}
