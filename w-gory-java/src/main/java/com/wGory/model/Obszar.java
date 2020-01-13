package com.wGory.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "OBSZAR")
@Data
public class Obszar {
    @Id
    private String symbol;
    private String nazwa;
    @OneToMany
    private List<Teren> tereny;
}
