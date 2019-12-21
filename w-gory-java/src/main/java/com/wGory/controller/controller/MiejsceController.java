package com.wGory.controller.controller;

import com.wGory.controller.service.MiejsceService;
import com.wGory.model.Miejsce;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/miejsca")
@RestController
@CrossOrigin
public class MiejsceController {

    private MiejsceService miejsceService;

    public MiejsceController(MiejsceService miejsceService) {
        this.miejsceService = miejsceService;
    }

    @GetMapping("/")
    public List<Miejsce> getAllDrivers() {
        return miejsceService.getAllMiejsca();
    }
}
