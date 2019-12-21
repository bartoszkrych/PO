package com.wGory.controller.repository;

import com.wGory.model.Miejsce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiejsceRepository extends JpaRepository<Miejsce, Integer> {
    List<Miejsce> findAll();
}
