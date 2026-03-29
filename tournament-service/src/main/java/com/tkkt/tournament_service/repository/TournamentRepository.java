package com.tkkt.repository;

import com.tkkt.entity.Season;
import com.tkkt.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament,Long> {

}
