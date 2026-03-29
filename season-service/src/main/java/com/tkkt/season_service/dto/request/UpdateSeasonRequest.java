package com.tkkt.season_service.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateSeasonRequest {
    private String seasonName;
    private Integer yearOfOrganization;
    private String description;
}
