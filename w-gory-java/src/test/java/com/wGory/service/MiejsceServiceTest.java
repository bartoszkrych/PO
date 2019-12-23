package com.wGory.service;

import com.wGory.controller.repository.MiejsceRepository;
import com.wGory.controller.service.MiejsceService;
import com.wGory.model.Miejsce;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MiejsceServiceTest {
    private MiejsceService miejsceService;

    private static final String DEFAULT_NAZWA = "DEFAULT";

    @Mock
    private MiejsceRepository miejsceRepository;

    @Before
    public void setup() {
        miejsceService = new MiejsceService(miejsceRepository);
    }

    @Test
    public void getAllMiejscaWhenFound() {
        // given
        List<Miejsce> miejsca = new ArrayList<>();
        miejsca.add(new Miejsce());
        Miejsce miejsce = new Miejsce();
        miejsce.setNazwa(DEFAULT_NAZWA);
        miejsca.add(miejsce);

        when(miejsceRepository.findAll()).thenReturn(miejsca);

        //when
        List<Miejsce> answer = miejsceService.getAllMiejsca();

        // then
        assertThat(answer.size()).isEqualTo(2);
        assertThat(answer.contains(miejsce)).isTrue();
    }

    @Test
    public void getAllMiejscaWhenNotFound() {
        // given
        when(miejsceRepository.findAll()).thenReturn(new ArrayList<>());

        // when
        List<Miejsce> answer = miejsceService.getAllMiejsca();

        // then
        assertThat(answer.isEmpty()).isTrue();
    }
}
