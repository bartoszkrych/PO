package com.wGory.controller.repository;

import com.wGory.model.Wycieczka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WycieczkaRepository extends JpaRepository<Wycieczka, Integer> {
}
