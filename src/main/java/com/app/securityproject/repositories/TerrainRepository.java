package com.app.securityproject.repositories;

import com.app.securityproject.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TerrainRepository extends JpaRepository<Terrain, Long> {
    // Terrain findByIdAvailable(Long id, boolean available);
    Optional<Terrain> findById(Long id);

}
