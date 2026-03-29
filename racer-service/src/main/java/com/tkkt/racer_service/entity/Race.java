package com.tkkt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

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

    @Column(name = "race_name", nullable = false)
    private String raceName;
    @Column(name = "description")
    private String description;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "length", nullable = false)
    private double length;
    @Column(name = "number_of_laps", nullable = false)
    private int numberOfLaps;


    private ArrayList<RaceResult> raceResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season1;
}
