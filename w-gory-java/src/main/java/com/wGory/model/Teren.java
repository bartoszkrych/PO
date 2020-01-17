package com.wGory.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEREN")
@Data
public class Teren {
    @Id
    private String nazwa;
    private Integer numer;
}
