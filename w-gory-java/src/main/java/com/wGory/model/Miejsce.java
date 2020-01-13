package com.wGory.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MIEJSCE")
@Data
public class Miejsce {
    @Id
    private String nazwa;
    @OneToOne
    private Obszar obszarGorski;
    @OneToOne
    private Teren terenGorski;
}
