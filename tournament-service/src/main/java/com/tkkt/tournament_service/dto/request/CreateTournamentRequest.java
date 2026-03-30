package com.tkkt.tournament_service.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTournamentRequest {
    private String tournamentName;
    private String description;
}
