package com.tkkt.race_service.service;

import com.tkkt.race_service.dto.request.CreateRaceRequest;
import com.tkkt.race_service.dto.request.UpdateRaceRequest;
import com.tkkt.race_service.entity.Race;
import com.tkkt.race_service.exception.AppException;
import com.tkkt.race_service.exception.ErrorCode;
import com.tkkt.race_service.repository.RaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RaceService {
    private final RaceRepository raceRepository;

    @Transactional(readOnly = true)
    public List<Race> findAllRaceBySeasonId(Long seasonId) {
        List<Race> races = raceRepository.findBySeasonId(seasonId);
        if (races.isEmpty()) {
            throw new AppException(ErrorCode.NOT_FOUND_RACE);
        }
        return races;
    }

    @Transactional
    public Race createRace(CreateRaceRequest createRaceRequest) {
        Race race = Race.builder()
                .seasonId(createRaceRequest.getSeasonId())
                .raceName(createRaceRequest.getRaceName())
                .description(createRaceRequest.getDescription())
                .location(createRaceRequest.getLocation())
                .date(createRaceRequest.getDate())
                .length(createRaceRequest.getLength())
                .numberOfLaps(createRaceRequest.getNumberOfLaps())
                .build();
        return raceRepository.save(race);
    }

    @Transactional(readOnly = true)
    public Race getRaceById(Long raceId) {
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_RACE));
        return race;
    }

    @Transactional
    public Race updateRace(Long id, UpdateRaceRequest updateRaceRequest) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_RACE));
        if (updateRaceRequest.getRaceName() != null) {
            race.setRaceName(updateRaceRequest.getRaceName());
        }
        if (updateRaceRequest.getDescription() != null) {
            race.setDescription(updateRaceRequest.getDescription());
        }
        if (updateRaceRequest.getLocation() != null) {
            race.setLocation(updateRaceRequest.getLocation());
        }
        if (updateRaceRequest.getDate() != null) {
            race.setDate(updateRaceRequest.getDate());
        }
        if (updateRaceRequest.getLength() != null) {
            race.setLength(updateRaceRequest.getLength());
        }
        if (updateRaceRequest.getNumberOfLaps() != null) {
            race.setNumberOfLaps(updateRaceRequest.getNumberOfLaps());
        }
        return raceRepository.save(race);
    }

    @Transactional
    public Race deleteRace(Long id) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_RACE));

        raceRepository.delete(race);
        return race;
    }


}
