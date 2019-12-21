package com.wGory.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEREN")
@Data
public class Teren {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nazwa;
    private Integer numer;
}
