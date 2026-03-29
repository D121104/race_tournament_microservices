package com.tkkt.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_racer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Racer extends Person implements Serializable {

    @Column(name = "car_number", unique = true)
    private Integer carNumber;

    @Column(name = "driver_role")
    private String driverRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "racer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<RaceResult> raceResults = new ArrayList<>();

    public void addRaceResult(RaceResult result) {
        this.raceResults.add(result);
        result.setRacer(this);
    }

}
