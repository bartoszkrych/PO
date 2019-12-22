package com.wGory.controller.service;

import com.wGory.controller.repository.TrasaPunktowanaRepository;
import com.wGory.model.Miejsce;
import com.wGory.model.TrasaPunktowana;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrasaPunktowanaService {
    private TrasaPunktowanaRepository trasaPunktowanaRepository;

    public TrasaPunktowanaService(TrasaPunktowanaRepository trasaPunktowanaRepository) {
        this.trasaPunktowanaRepository = trasaPunktowanaRepository;
    }

    public List<TrasaPunktowana> findByPoczatekAndKoniec(Miejsce poczatek, Miejsce koniec)
    {
        return trasaPunktowanaRepository.findByPoczatekAndKoniec(poczatek,koniec);
    }

    public TrasaPunktowana addTrasaPunkt(TrasaPunktowana trasaPunkt)
    {
        return trasaPunktowanaRepository.save(trasaPunkt);
    }
}
