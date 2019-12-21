package com.wGory.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "TRASA_WLASNA")
@Data
public class TrasaWlasna extends OdcinekTrasy {
    private String nazwa;
    private String opis;
    private Integer przewyzszenie;
    private Integer dlugosc;

    @Transient
    private Integer punkty;

    @PostLoad
    private void postLoad() {
        punkty = dlugosc / 1000 + BigDecimal.valueOf((przewyzszenie - 1) / (double) 100).setScale(0, RoundingMode.HALF_UP).intValue();
    }
}
