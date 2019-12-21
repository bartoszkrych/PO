package com.wGory.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ODCINEK_WYCIECZKI")
@Data
public class OdcinekWycieczki {

    @EmbeddedId
    private OdcinekWycieczkiKlucz id;

    @ManyToOne
    @MapsId("wycieczkaId")
    @JoinColumn(name = "wycieczka_id")
    private Wycieczka wycieczka;

    @ManyToOne
    @MapsId("odcinekTrasyId")
    @JoinColumn(name = "odcinek_trasy_id")
    private OdcinekTrasy odcinekTrasy;

}

@Embeddable
@Data
class OdcinekWycieczkiKlucz implements Serializable {
    @Column(name = "wycieczka_id")
    Integer wycieczkaId;

    @Column(name = " odcinek_trasy_id")
    Integer odcinekTrasyId;
}
