package com.tkkt.race_service.repository;

import com.tkkt.race_service.entity.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface RaceRepository extends JpaRepository< Race,  Long> {
    List<Race> findBySeasonId(Long seasonId);
    Page<Race> findBySeasonId(Long seasonId, Pageable pageable);
}
