package com.example.vetcare.entity;

import com.example.vetcare.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime date;

    @OneToOne
    private PetOwner petOwner;

    @OneToOne
    private VeterinaryOffice veterinaryOffice;

    @Column
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

}
