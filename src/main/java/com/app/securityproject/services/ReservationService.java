package com.app.securityproject.services;

import com.app.securityproject.entities.Reservation;

import com.app.securityproject.repositories.ReservationRepository;
import com.app.securityproject.repositories.TerrainRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final TerrainRepository terrainRepository;

    public ReservationService(ReservationRepository reservationRepository, TerrainRepository terrainRepository) {
        this.reservationRepository = reservationRepository;
        this.terrainRepository = terrainRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        if (!checkAvailability(reservation.getTerrain().getId(), reservation.getStartTime(), reservation.getEndTime())) {
            throw new RuntimeException("Le terrain n'est pas disponible pour cette période");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public boolean checkAvailability(Long terrainId, LocalDateTime startTime, LocalDateTime endTime) {
        return reservationRepository.findByTerrainAndStartTimeBetween(terrainId, endTime, startTime).isEmpty();
    }
}