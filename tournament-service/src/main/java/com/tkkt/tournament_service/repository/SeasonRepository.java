package com.tkkt.repository;

import com.tkkt.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season,Long> {
    List<Season> findByTournament(String seasonName);
}
