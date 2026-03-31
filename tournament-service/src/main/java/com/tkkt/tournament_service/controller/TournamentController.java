package com.tkkt.tournament_service.controller;

import com.tkkt.tournament_service.dto.ApiResponse;
import com.tkkt.tournament_service.dto.request.CreateTournamentRequest;
import com.tkkt.tournament_service.dto.request.UpdateTournamentRequest;
import com.tkkt.tournament_service.entity.Tournament;
import com.tkkt.tournament_service.service.TournamentService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    @PostMapping("create-tournament")
    public ApiResponse<Tournament> createTournament(
            @RequestBody CreateTournamentRequest createTournamentRequest) {
        return ApiResponse.<Tournament>builder()
                .code(201)
                .message("")
                .result(tournamentService.createTournament(createTournamentRequest))
                .build();
    }

    @GetMapping("{tournamentId}")
    public ApiResponse<Tournament> getTournamentById(@PathVariable("tournamentId") Long tournamentId) {
        return ApiResponse.<Tournament>builder()
                .code(201)
                .message("")
                .result(tournamentService.getTournamentById(tournamentId))
                .build();
    }

    @GetMapping
    public ApiResponse<Page<Tournament>> getAllTournaments(@PageableDefault(size = 10) Pageable pageable) {
        return ApiResponse.<Page<Tournament>>builder()
                .code(201)
                .message("")
                .result(tournamentService.getAllTournaments(pageable))
                .build();
    }

    @Cacheable("tournaments-all")
    @GetMapping("all")
    public ApiResponse<List<Tournament>> getAllTournament() {
        return ApiResponse.<List<Tournament>>builder()
                .code(201)
                .message("")
                .result(tournamentService.getAllTournaments())
                .build();
    }

    @PostMapping("update-tournament/{tournamentId}")
    public ApiResponse<Tournament> updateTournamentById(
            @PathVariable("tournamentId") Long tournamentId,
            @RequestBody UpdateTournamentRequest updateTournamentRequest) {
        return ApiResponse.<Tournament>builder()
                .code(200)
                .message("")
                .result(tournamentService.updateTournamentById(tournamentId, updateTournamentRequest))
                .build();
    }

    @DeleteMapping("{tournamentId}")
    public ApiResponse<Tournament> deleteTournamentById(
            @PathVariable("tournamentId") Long tournamentId) {
        return ApiResponse.<Tournament>builder()
                .code(200)
                .message("")
                .result(tournamentService.daleteTournamentById(tournamentId))
                .build();
    }
}
