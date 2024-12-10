package com.app.securityproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private boolean available;

    private String location;
    @JsonIgnore
    @OneToMany(mappedBy = "terrain", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations; // Relation avec les réservations

    // Getters et Setters
}
