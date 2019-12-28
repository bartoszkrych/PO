package com.wGory.controller.controller;

import com.wGory.controller.service.TrasaPunktowanaService;
import com.wGory.model.TrasaPunktowana;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/trasy-punktowane")
@RestController
@CrossOrigin
public class TrasaPunktowanaController {

    private TrasaPunktowanaService trasaPunktowanaService;

    public TrasaPunktowanaController(TrasaPunktowanaService trasaPunktowanaService) {
        this.trasaPunktowanaService = trasaPunktowanaService;
    }

    @ApiOperation(value = "Dodanie nieistnijącej trasy punktowanej z takim początkiem i końcem w bazie danych.")
    @ApiImplicitParam(
            name = "trasaPunkt",
            value = "Nowa, nie istniejaca w bazie danych trasa punktowana stworzona przez użytkownika do zapisania w bazie danych. ",
            required = true,
            dataType = "TrasaPunktowana")
    @PostMapping("/addTrasaPunkt")
    public ResponseEntity<TrasaPunktowana> addTrasaPunkt(@RequestBody TrasaPunktowana trasaPunkt) {
        return ResponseEntity.ok(trasaPunktowanaService.addTrasaPunkt(trasaPunkt));
    }
}
