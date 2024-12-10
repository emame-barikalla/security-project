package com.app.securityproject.services;

import com.app.securityproject.entities.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Reservation createReservation(Reservation reservation);
    boolean checkAvailability(Long terrainId, LocalDateTime startTime, LocalDateTime endTime);

}
