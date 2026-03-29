package com.tkkt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int Long;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "dob", nullable = false)
    private String dob;
    @Column(name = "email",  nullable = false)
    private String email;
    @Column(name = "phone",  nullable = false)
    private String phone;

}
