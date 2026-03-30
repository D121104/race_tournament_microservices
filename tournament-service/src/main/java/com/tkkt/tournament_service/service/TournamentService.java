package com.tkkt.tournament_service.service;

import com.tkkt.tournament_service.dto.ApiResponse;
import com.tkkt.tournament_service.dto.request.CreateTournamentRequest;
import com.tkkt.tournament_service.dto.request.UpdateTournamentRequest;
import com.tkkt.tournament_service.entity.Tournament;
import com.tkkt.tournament_service.exception.AppException;
import com.tkkt.tournament_service.exception.ErrorCode;
import com.tkkt.tournament_service.repository.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Transactional
    public Tournament createTournament(CreateTournamentRequest createTournamentRequest) {
        Tournament tournament = Tournament.builder()
                .tournamentName(createTournamentRequest.getTournamentName())
                .description(createTournamentRequest.getDescription())
                .build();
        return tournamentRepository.save(tournament);
    }

    @Transactional(readOnly = true)
    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOURNAMENT_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<Tournament> getAllTournament() {
        return tournamentRepository.getAllTournament();
    }

    @Transactional
    public Tournament updateTournamentById(Long id, UpdateTournamentRequest updateTournamentRequest) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOURNAMENT_NOT_FOUND));

        if (updateTournamentRequest.getTournamentName() != null) {
            tournament.setTournamentName(updateTournamentRequest.getTournamentName());
        }

        if (updateTournamentRequest.getDescription() != null) {
            tournament.setDescription(updateTournamentRequest.getDescription());
        }

        return tournamentRepository.save(tournament);
    }

    @Transactional
    public Tournament daleteTournamentById(Long id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOURNAMENT_NOT_FOUND));
        tournamentRepository.delete(tournament);
        return tournament;
    }
}
