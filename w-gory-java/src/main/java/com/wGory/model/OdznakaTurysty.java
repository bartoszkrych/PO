package com.wGory.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ODZNAKA_TURYSTY")
public class OdznakaTurysty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dataRozpoczecia;
    private LocalDate dataZdobycia;
    private Boolean czyNormySpelnione;
    private Boolean czyZdobyta;
}
