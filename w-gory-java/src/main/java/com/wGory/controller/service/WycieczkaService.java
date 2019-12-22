package com.wGory.controller.service;

import com.wGory.controller.repository.WycieczkaRepository;
import com.wGory.model.StatusWycieczki;
import com.wGory.model.Wycieczka;
import org.springframework.stereotype.Service;

@Service
public class WycieczkaService {
    private WycieczkaRepository wycieczkaRepository;

    public WycieczkaService(WycieczkaRepository wycieczkaRepository) {
        this.wycieczkaRepository = wycieczkaRepository;
    }

    public Wycieczka getWycieczkaById(Integer id)
    {
        return wycieczkaRepository.findById(id).orElse(null);
    }

    public Wycieczka setWycieczkaDone(Integer id)
    {
        var wycieczka = wycieczkaRepository.findById(id).orElse(null);

        if(wycieczka == null) return null;

        if(wycieczka.getStatus() != StatusWycieczki.Zaplanowana) return null;

        wycieczka.setStatus(StatusWycieczki.Odbyta);
        return wycieczkaRepository.save(wycieczka);

    }
}
