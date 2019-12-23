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

    public TrasaPunktowana addTrasaPunkt(TrasaPunktowana trasaPunkt)
    {
        var poczatek = trasaPunkt.getPoczatek();
        var koniec = trasaPunkt.getKoniec();

        var trasy =trasaPunktowanaRepository.findByPoczatekAndKoniec(poczatek,koniec);

        if(trasy.isEmpty())return trasaPunktowanaRepository.save(trasaPunkt);

        return null;
    }
}
