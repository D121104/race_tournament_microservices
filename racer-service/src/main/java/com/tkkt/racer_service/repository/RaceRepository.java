package com.tkkt.repository;

import com.tkkt.entity.Race;
import com.tkkt.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaceRepository extends JpaRepository< Race,  Long> {
    List< Race> findBySeason(Season season);
}
