package com.example.vetcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "veterinary_offices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VeterinaryOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne
    private User user;

    @Column
    private String address;

}
