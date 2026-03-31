package com.tkkt.tournament_service.repository;

import com.tkkt.tournament_service.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament,Long> {

}
