package com.wGory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TRASA_WLASNA")
@Data
@PrimaryKeyJoinColumn(name = "trasa_wlasna_id")
public class TrasaWlasna extends OdcinekTrasy {
    private String nazwa;
    private String opis;
    private Integer przewyzszenie;
    private Integer dlugosc;

    @Transient
    private Integer punkty;

    @PostLoad
    @PostUpdate
    @PostPersist
    private void postOperation() {
        punkty = dlugosc / 1000 + BigDecimal.valueOf((przewyzszenie - 1) / (double) 100).setScale(0, RoundingMode.HALF_UP).intValue();
    }
}
