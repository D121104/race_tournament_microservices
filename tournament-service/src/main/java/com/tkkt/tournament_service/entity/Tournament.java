package com.tkkt.tournament_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_tournaments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "tournament_name", nullable = false)
    private String tournamentName;

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Builder.Default
//    private List<Season> seasons = new ArrayList<>();
//
//    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Builder.Default
//    private List<Employee> employees = new ArrayList<>();
}
