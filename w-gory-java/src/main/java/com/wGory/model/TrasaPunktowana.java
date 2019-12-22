package com.wGory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TRASA_PUNKTOWANA")
@Data
@PrimaryKeyJoinColumn(name = "trasa_punktowana_id")
public class TrasaPunktowana extends OdcinekTrasy {
    @OneToOne
    private Miejsce poczatek;
    @OneToOne
    private Miejsce koniec;
    private Integer punkty;
}
