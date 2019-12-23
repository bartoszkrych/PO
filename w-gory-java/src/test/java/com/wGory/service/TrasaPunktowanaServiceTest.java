package com.wGory.service;

import com.wGory.controller.repository.TrasaPunktowanaRepository;
import com.wGory.controller.service.TrasaPunktowanaService;
import com.wGory.model.Miejsce;
import com.wGory.model.Obszar;
import com.wGory.model.TrasaPunktowana;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrasaPunktowanaServiceTest {
    private TrasaPunktowanaService trasaPunktowanaService;

    private static final String DEFAULT_NAZWA = "DEFAULT";
    private static final String DEFAULT_OBSZAR = "DEFAULT_OBSZAR";

    @Mock
    private TrasaPunktowanaRepository trasaPunktowanaRepository;

    @Before
    public void setup() {
        trasaPunktowanaService = new TrasaPunktowanaService(trasaPunktowanaRepository);
    }

    @Test
    public void addTrasaPunktWhenAdded() {
        // given
        Obszar obszar = new Obszar();
        obszar.setNazwa(DEFAULT_OBSZAR);

        Miejsce poczatek = new Miejsce();
        poczatek.setObszarGorski(obszar);
        Miejsce koniec = new Miejsce();
        koniec.setObszarGorski(obszar);

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setPoczatek(poczatek);
        trasaPunktowana.setKoniec(koniec);

        when(trasaPunktowanaRepository.findByPoczatekAndKoniec(poczatek, koniec)).thenReturn(new ArrayList<>());
        when(trasaPunktowanaRepository.save(trasaPunktowana)).thenReturn(trasaPunktowana);

        // when
        TrasaPunktowana answer = trasaPunktowanaService.addTrasaPunkt(trasaPunktowana);

        // then
        assertThat(answer).isEqualTo(trasaPunktowana);
    }

    @Test
    public void addTrasaPunktWhenExisted() {
        // given
        Obszar obszar = new Obszar();
        obszar.setNazwa(DEFAULT_OBSZAR);

        Miejsce poczatek = new Miejsce();
        poczatek.setObszarGorski(obszar);
        Miejsce koniec = new Miejsce();
        koniec.setObszarGorski(obszar);

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setPoczatek(poczatek);
        trasaPunktowana.setKoniec(koniec);

        when(trasaPunktowanaRepository.findByPoczatekAndKoniec(poczatek, koniec)).thenReturn(new ArrayList<>(1));

        // when
        TrasaPunktowana answer = trasaPunktowanaService.addTrasaPunkt(trasaPunktowana);

        // then
        assertThat(answer).isEqualTo(null);
    }

    @Test
    public void addTrasaPunktWhenWrongObszarGorski() {
        // given
        Obszar obszar = new Obszar();
        obszar.setNazwa(DEFAULT_OBSZAR);
        Obszar obszar_2 = new Obszar();
        obszar_2.setNazwa(DEFAULT_NAZWA + "_2");

        Miejsce poczatek = new Miejsce();
        poczatek.setObszarGorski(obszar);
        Miejsce koniec = new Miejsce();
        koniec.setObszarGorski(obszar);

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setPoczatek(poczatek);
        trasaPunktowana.setKoniec(koniec);

        // when
        TrasaPunktowana answer = trasaPunktowanaService.addTrasaPunkt(trasaPunktowana);

        // then
        assertThat(answer).isEqualTo(null);
    }

    @Test
    public void addTrasaPunktWhenPoczatekIsNull() {
        // given
        Obszar obszar = new Obszar();
        obszar.setNazwa(DEFAULT_OBSZAR);

        Miejsce koniec = new Miejsce();
        koniec.setObszarGorski(obszar);

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setKoniec(koniec);

        // when
        TrasaPunktowana answer = trasaPunktowanaService.addTrasaPunkt(trasaPunktowana);

        // then
        assertThat(answer).isEqualTo(null);
    }

    @Test
    public void addTrasaPunktWhenKoniecIsNull() {
        // given
        Obszar obszar = new Obszar();
        obszar.setNazwa(DEFAULT_OBSZAR);

        Miejsce poczatek = new Miejsce();
        poczatek.setObszarGorski(obszar);

        TrasaPunktowana trasaPunktowana = new TrasaPunktowana();
        trasaPunktowana.setPoczatek(poczatek);

        // when
        TrasaPunktowana answer = trasaPunktowanaService.addTrasaPunkt(trasaPunktowana);

        // then
        assertThat(answer).isEqualTo(null);
    }
}
