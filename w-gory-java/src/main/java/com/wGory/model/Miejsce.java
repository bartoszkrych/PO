package com.wGory.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MIEJSCE")
@Data
public class Miejsce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nazwa;
    @OneToOne
    private Obszar obszarGorski;
    @OneToOne
    private Teren terenGorski;
}
