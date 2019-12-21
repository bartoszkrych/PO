package com.wGory.controller.service;

import com.wGory.controller.repository.MiejsceRepository;
import com.wGory.model.Miejsce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiejsceService {
    private MiejsceRepository miejsceRepository;

    public MiejsceService(MiejsceRepository miejsceRepository) {
        this.miejsceRepository = miejsceRepository;
    }

    public List<Miejsce> getAllMiejsca() {
        return miejsceRepository.findAll();
    }
}
