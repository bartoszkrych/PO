package com.wGory.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRASA_PUNKTOWANA")
@Data
public class TrasaPunktowana extends OdcinekTrasy {
    @OneToOne
    private Miejsce poczatek;
    @OneToOne
    private Miejsce koniec;
    private Integer punkty;
//    @OneToOne
//    @Formula("koniec.getObszarGorski()")
//    private Obszar obszarGorski;
//    @OneToOne
//    @Formula("koniec.getTerenGorski()")
//    private Teren terenGorski;
}
