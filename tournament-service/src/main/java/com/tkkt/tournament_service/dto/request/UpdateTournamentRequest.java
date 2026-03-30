package com.tkkt.tournament_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTournamentRequest {
    private String tournamentName;
    private String description;
}
