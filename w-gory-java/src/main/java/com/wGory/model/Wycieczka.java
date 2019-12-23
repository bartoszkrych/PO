package com.wGory.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private StatusWycieczki status = StatusWycieczki.Zaplanowana;

    @ManyToOne
    private OdznakaTurysty odznakaTurysty;
    @OneToMany
    private List<OdcinekWycieczki> odcinkiWycieczki;

    @Transient
    private Integer punktyWycieczki;

    @PostLoad
    private void postLoad() {

        punktyWycieczki = odcinkiWycieczki.stream().mapToInt(oW -> oW.getOdcinekTrasy().getPunkty()).sum();
    }

}
