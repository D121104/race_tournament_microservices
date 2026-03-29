package com.tkkt.race_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_races")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Race implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "season_id", updatable = false, nullable = false)
    private Long seasonId;

    @Column(name = "race_name", nullable = false)
    private String raceName;
    @Column(name = "description")
    private String description;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "length", nullable = false)
    private Double length;
    @Column(name = "number_of_laps", nullable = false)
    private Integer numberOfLaps;


//    private ArrayList<RaceResult> raceResults;

}
