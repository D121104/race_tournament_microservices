package com.tkkt.season_service.service;

import com.tkkt.season_service.dto.request.CreateSeasonRequest;
import com.tkkt.season_service.dto.request.UpdateSeasonRequest;
import com.tkkt.season_service.entity.Season;
import com.tkkt.season_service.exception.AppException;
import com.tkkt.season_service.exception.ErrorCode;
import com.tkkt.season_service.repository.SeasonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SeasonService {
    private final SeasonRepository seasonRepository;

    @Transactional(readOnly = true)
    public List<Season> findAllSeasonByTournamentId(Long tournamentId) {
        return seasonRepository.findByTournamentId(tournamentId);
    }

    @Transactional(readOnly = true)
    public Season getSeasonById(Long seasonId) {
        return seasonRepository.findById(seasonId)
                .orElseThrow(() -> new AppException(ErrorCode.SEASON_NOT_FOUND));
    }

    @Transactional
    public Season createSeason(CreateSeasonRequest createSeasonRequest) {
        Season season = Season.builder()
                .tournamentId(createSeasonRequest.getTournamentId())
                .seasonName(createSeasonRequest.getSeasonName())
                .yearOfOrganization(createSeasonRequest.getYearOfOrganization())
                .description(createSeasonRequest.getDescription())
                .build();

        return seasonRepository.save(season);
    }

    @Transactional
    public Season updateSeason(Long seasonId, UpdateSeasonRequest updateSeasonRequest) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new AppException(ErrorCode.SEASON_NOT_FOUND));
        if (updateSeasonRequest.getSeasonName() != null) {
            season.setSeasonName(updateSeasonRequest.getSeasonName());
        }
        if (updateSeasonRequest.getYearOfOrganization() != null) {
            season.setYearOfOrganization(updateSeasonRequest.getYearOfOrganization());
        }
        if (updateSeasonRequest.getDescription() != null) {
            season.setDescription(updateSeasonRequest.getDescription());
        }
        return seasonRepository.save(season);
    }

    @Transactional
    public Season deleteSeason(Long seasonId) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new AppException(ErrorCode.SEASON_NOT_FOUND));
        seasonRepository.deleteById(seasonId);
        return season;
    }
}
