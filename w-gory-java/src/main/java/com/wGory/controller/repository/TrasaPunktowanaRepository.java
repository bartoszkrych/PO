package com.wGory.controller.repository;

import com.wGory.model.Miejsce;
import com.wGory.model.TrasaPunktowana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrasaPunktowanaRepository extends JpaRepository<TrasaPunktowana, Integer> {
    List<TrasaPunktowana> findByPoczatekAndKoniec(Miejsce poczatek, Miejsce koniec);
}
