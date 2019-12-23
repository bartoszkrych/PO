package com.wGory.service;

import com.wGory.controller.repository.WycieczkaRepository;
import com.wGory.controller.service.WycieczkaService;
import com.wGory.model.StatusWycieczki;
import com.wGory.model.Wycieczka;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WycieczkaServiceTest {
    private WycieczkaService wycieczkaService;
    private static final Integer DEFAULT_ID = 999;
    private static final LocalDate LOCAL_DATE_NOW = LocalDate.now();

    @Mock
    WycieczkaRepository wycieczkaRepository;

    @Before
    public void setup() {
        wycieczkaService = new WycieczkaService(wycieczkaRepository);
    }

    @Test
    public void getWycieczkaByIdWhenFound() {
        // when
        Wycieczka wycieczka = new Wycieczka();
        wycieczka.setId(DEFAULT_ID);
        wycieczka.setOdcinkiWycieczki(new ArrayList<>());

        when(wycieczkaRepository.findById(DEFAULT_ID)).thenReturn(Optional.of(wycieczka));

        // given
        Wycieczka answer = wycieczkaService.getWycieczkaById(DEFAULT_ID);

        // then
        assertThat(answer).isEqualTo(wycieczka);
    }

    @Test
    public void getWycieczkaByIdWhenNotFound() {
        // when
        when(wycieczkaRepository.findById(DEFAULT_ID)).thenReturn(Optional.empty());

        // given
        Wycieczka answer = wycieczkaService.getWycieczkaById(DEFAULT_ID);

        // then
        assertThat(answer).isNull();
    }

    @Test
    public void setWycieczkaDoneWhenIsOk() {
        // when
        Wycieczka wycieczka = new Wycieczka();
        wycieczka.setPlanowanaData(LOCAL_DATE_NOW.minusDays(1));

        Wycieczka wycieczka_odbyta = new Wycieczka();
        wycieczka_odbyta.setPlanowanaData(wycieczka.getPlanowanaData());
        wycieczka_odbyta.setStatus(StatusWycieczki.Odbyta);

        when(wycieczkaRepository.findById(DEFAULT_ID)).thenReturn(Optional.of(wycieczka));
        when(wycieczkaRepository.save(wycieczka_odbyta)).thenReturn(wycieczka_odbyta);

        // given
        Wycieczka answer = wycieczkaService.setWycieczkaDone(DEFAULT_ID);

        // then
        assertThat(answer).isEqualTo(wycieczka_odbyta);
    }

    @Test
    public void setWycieczkaDoneWhenWrongStatus() {
        // when
        Wycieczka wycieczka = new Wycieczka();
        wycieczka.setPlanowanaData(LOCAL_DATE_NOW.minusDays(1));
        wycieczka.setStatus(StatusWycieczki.Odbyta);

        when(wycieczkaRepository.findById(DEFAULT_ID)).thenReturn(Optional.of(wycieczka));

        // given
        Wycieczka answer = wycieczkaService.setWycieczkaDone(DEFAULT_ID);

        // then
        assertThat(answer).isNull();
    }

    @Test
    public void setWycieczkaDoneWhenWrongDate() {
        // when
        Wycieczka wycieczka = new Wycieczka();
        wycieczka.setPlanowanaData(LOCAL_DATE_NOW.plusDays(1));

        when(wycieczkaRepository.findById(DEFAULT_ID)).thenReturn(Optional.of(wycieczka));

        // given
        Wycieczka answer = wycieczkaService.setWycieczkaDone(DEFAULT_ID);

        // then
        assertThat(answer).isNull();
    }

    @Test
    public void setWycieczkaDoneWhenNotFound() {
        // when
        when(wycieczkaRepository.findById(DEFAULT_ID)).thenReturn(Optional.empty());

        // given
        Wycieczka answer = wycieczkaService.setWycieczkaDone(DEFAULT_ID);

        // then
        assertThat(answer).isNull();
    }

}
