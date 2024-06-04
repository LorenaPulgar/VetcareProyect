package com.example.vetcare.controller;

import com.example.vetcare.dto.appointment.AppointmentDTO;
import com.example.vetcare.dto.appointment.AppointmentToSaveDTO;
import com.example.vetcare.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentToSaveDTO appointment) {

        AppointmentDTO savedAppointment = appointmentService.create(appointment);

        return ResponseEntity.ok(savedAppointment);
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public ResponseEntity<List<AppointmentDTO>> index() {

        List<AppointmentDTO> savedAppointment = appointmentService.getAll();

        return ResponseEntity.ok(savedAppointment);
    }
}
