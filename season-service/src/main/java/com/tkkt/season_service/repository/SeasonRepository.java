package com.tkkt.season_service.repository;

import com.tkkt.season_service.entity.Season;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season,Long> {
    List<Season> findByTournamentId(Long tournamentId);
    Page<Season> findByTournamentId(Long tournamentId, Pageable pageable);
}
