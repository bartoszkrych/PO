package com.wGory.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WYCIECZKA")
@Data
public class Wycieczka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Nullable
    private String nazwa;
    @Nullable
    private LocalDate planowanaData;
    @Nullable
    private LocalDate dataUtworzenia = LocalDate.now();

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
        ArrayList<OdcinekTrasy> odbyteOdcinki = new ArrayList<>();

        for (OdcinekWycieczki odcinekWycieczki : odcinkiWycieczki) {
            if (odcinekWycieczki.getCzyOdbyta()) odbyteOdcinki.add(odcinekWycieczki.getOdcinekTrasy());
        }
        punktyWycieczki = odbyteOdcinki.stream().mapToInt(OdcinekTrasy::getPunkty).sum();
    }

}
