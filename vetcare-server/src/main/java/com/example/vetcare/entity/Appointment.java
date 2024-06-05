package com.example.vetcare.entity;

import com.example.vetcare.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @OneToOne
    private PetOwner petOwner;

    @OneToOne
    private VeterinaryOffice veterinaryOffice;

    @Column
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

}
