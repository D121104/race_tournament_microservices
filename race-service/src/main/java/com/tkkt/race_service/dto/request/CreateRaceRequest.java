package com.tkkt.race_service.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateRaceRequest {
    private Long seasonId;
    private String raceName;
    private String description;
    private String location;
    private String date;
    private Double length;
    private Integer numberOfLaps;
}
