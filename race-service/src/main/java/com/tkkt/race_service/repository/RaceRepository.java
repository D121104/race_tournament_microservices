package com.tkkt.race_service.repository;

import com.tkkt.race_service.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepository extends JpaRepository< Race,  Long> {
    List<Race> findBySeasonId(Long seasonId);
}
