package com.tkkt.race_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateRaceRequest {
    private String raceName;
    private String description;
    private String location;
    private String date;
    private Double length;
    private Integer numberOfLaps;
}
