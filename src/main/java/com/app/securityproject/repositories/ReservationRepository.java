package com.app.securityproject.repositories;

import com.app.securityproject.entities.Reservation;
import com.app.securityproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByTerrainAndStartTimeBetween(Long terrainId, LocalDateTime start, LocalDateTime end);
}

