package com.wGory.controller.service;

import com.wGory.controller.repository.TrasaPunktowanaRepository;
import com.wGory.model.TrasaPunktowana;
import org.springframework.stereotype.Service;

@Service
public class TrasaPunktowanaService {
    private TrasaPunktowanaRepository trasaPunktowanaRepository;

    public TrasaPunktowanaService(TrasaPunktowanaRepository trasaPunktowanaRepository) {
        this.trasaPunktowanaRepository = trasaPunktowanaRepository;
    }

    public TrasaPunktowana addTrasaPunkt(TrasaPunktowana trasaPunkt) {
        var poczatek = trasaPunkt.getPoczatek();
        var koniec = trasaPunkt.getKoniec();
        if (poczatek == null || koniec == null) return null;
        if (!poczatek.getObszarGorski().equals(koniec.getObszarGorski())) return null;

        var trasy = trasaPunktowanaRepository.findByPoczatekAndKoniec(poczatek, koniec);
        if (!trasy.isEmpty()) return null;

        return trasaPunktowanaRepository.save(trasaPunkt);
    }
}
