package com.example.vetcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veterinary_offices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VeterinaryOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column
    private String address;

}
