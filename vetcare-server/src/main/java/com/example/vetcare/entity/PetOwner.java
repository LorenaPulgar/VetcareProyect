package com.example.vetcare.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pet_owners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Pet> pets;

}
