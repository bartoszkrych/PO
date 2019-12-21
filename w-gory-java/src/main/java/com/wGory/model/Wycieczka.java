package com.wGory.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WYCIECZKA")
@Data
public class Wycieczka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nazwa;
    private LocalDate planowanaData;
    private LocalDate dataUtworzenia;

    @Enumerated(EnumType.STRING)
    private StatusWycieczki status;

    @ManyToOne
    private OdznakaTurysty odznakaTurysty;

    @Transient
    private Integer punktyWycieczki;

    @PostLoad
    private void postLoad() {
        punktyWycieczki = 10;
    }

}
