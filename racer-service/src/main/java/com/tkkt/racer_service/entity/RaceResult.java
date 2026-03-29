package com.tkkt.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_race_result", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"race_id", "racer_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RaceResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "racer_id", nullable = false)
    private Racer racer;

    @Column(name = "race_time_ms")
    private Long raceTimeMs;

    @Column(name = "laps_completed")
    private Integer lapsCompleted;

    @Column(name = "final_position")
    private Integer finalPosition;

    @Column(nullable = false)
    @Builder.Default
    private double points = 0.0;

}
