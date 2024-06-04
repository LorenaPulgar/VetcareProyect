package com.example.vetcare.service;

import com.example.vetcare.dto.appointment.AppointmentDTO;
import com.example.vetcare.dto.appointment.AppointmentMapper;
import com.example.vetcare.dto.appointment.AppointmentToSaveDTO;
import com.example.vetcare.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public AppointmentDTO create(AppointmentToSaveDTO appointment) {
        var newAppointment = appointmentMapper.appointmentSaveDTOToAppointment(appointment);
        var savedAppointment = appointmentRepository.save(newAppointment);
        return appointmentMapper.appointmentToAppointmentDTO(savedAppointment);
    }

    public List<AppointmentDTO> getAll() {
        var appointments = appointmentRepository.findAll();

        var appointmentsDto = appointments.stream()
                .map(appointmentMapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());

        return appointmentsDto;
    }
}
