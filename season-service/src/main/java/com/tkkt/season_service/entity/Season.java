package com.tkkt.season_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "tbl_seasons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Season implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "tournament_id", updatable = false, nullable = false)
    private Long tournamentId;

    @Column(name = "season_name", nullable = false)
    private String seasonName;
    @Column(name = "year_of_organization", nullable = false)
    private Integer yearOfOrganization;
    @Column(name = "description")
    private String description;


}
