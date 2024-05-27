package com.example.vetcare.dto.appointment;

import com.example.vetcare.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);
    Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO);
    Appointment appointmentSaveDTOToAppointment(AppointmentToSaveDTO appointmentToSaveDTO);
}
