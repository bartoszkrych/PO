package com.wGory.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OBSZAR")
@Data
public class Obszar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String symbol;
    private String nazwa;
    @OneToMany
    private List<Teren> tereny;
}
