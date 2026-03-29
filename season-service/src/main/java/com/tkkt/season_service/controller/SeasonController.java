package com.tkkt.season_service.controller;

import com.tkkt.season_service.dto.ApiResponse;
import com.tkkt.season_service.dto.request.CreateSeasonRequest;
import com.tkkt.season_service.dto.request.UpdateSeasonRequest;
import com.tkkt.season_service.entity.Season;
import com.tkkt.season_service.service.SeasonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/seasons")
public class SeasonController {
    private final SeasonService seasonService;

    @PostMapping("create-season")
    public ApiResponse<Season> createSeason(@RequestBody CreateSeasonRequest createSeasonRequest) {
        return ApiResponse.<Season>builder()
                .code(201)
                .message("")
                .result(seasonService.createSeason(createSeasonRequest))
                .build();
    }

    @GetMapping("{seasonId}")
    public ApiResponse<Season> getSeasonById(@PathVariable("seasonId") Long seasonId) {
        return ApiResponse.<Season>builder()
                .code(200)
                .message("")
                .result(seasonService.getSeasonById(seasonId))
                .build();
    }

    @GetMapping("tournament/{tournamentId}")
    public ApiResponse<List<Season>> getAllSeasonsByTournamentId(@PathVariable("tournamentId") Long tournamentId) {
        return ApiResponse.<List<Season>>builder()
                .code(200)
                .message("")
                .result(seasonService.findAllSeasonByTournamentId(tournamentId))
                .build();
    }

    @PostMapping("update-season/{seasonId}")
    public ApiResponse<Season> updateSeason(@PathVariable("seasonId") Long seasonId,
                                            @RequestBody UpdateSeasonRequest updateSeasonRequest) {
        return ApiResponse.<Season>builder()
                .code(200)
                .message("")
                .result(seasonService.updateSeason(seasonId ,updateSeasonRequest))
                .build();
    }

    @DeleteMapping("{seasonId}")
    public ApiResponse<Season> deleteSeasonById(@PathVariable("seasonId") Long seasonId) {
        return ApiResponse.<Season>builder()
                .code(200)
                .message("")
                .result(seasonService.deleteSeason(seasonId))
                .build();
    }
}
