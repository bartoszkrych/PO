package com.wGory.controller.controller;

import com.wGory.controller.service.TrasaPunktowanaService;
import com.wGory.model.Miejsce;
import com.wGory.model.TrasaPunktowana;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/trasy-punktowane")
@RestController
@CrossOrigin
public class TrasaPunktowanaController {

    private TrasaPunktowanaService trasaPunktowanaService;

    public TrasaPunktowanaController(TrasaPunktowanaService trasaPunktowanaService) {
        this.trasaPunktowanaService = trasaPunktowanaService;
    }

    @ApiOperation(value = "Przeszukanie bazy danych w celu znalezienia istniejącej już trasy punktowanej z podanymi miejscami początkowymi i końcowymi.")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "poczatek",
                    value = "Miejsce początkowe trasy punktowanej.",
                    required = true,
                    dataType = "Miejsce"), // find example to object
            @ApiImplicitParam(
                    name = "koniec",
                    value = "Miejsce końcowe trasy punktowanej.",
                    required = true,
                    dataType = "Miejsce")
    })
    public List<TrasaPunktowana> findyByPoczatekAndKoniec(Miejsce poczatek, Miejsce koniec)
    {
        return trasaPunktowanaService.findByPoczatekAndKoniec(poczatek,koniec);
    }


    @ApiImplicitParam(
            name = "trasaPunkt",
            value = "Nowa, nie istniejaca w bazie danych trasa punktowana stworzona przez użytkownika do zapisania w bazie danych. ",
            required = true,
            dataType = "TrasaPunktowana")
    @PostMapping("/addDriver")
    public TrasaPunktowana addTrasaPunkt(@Valid @RequestBody TrasaPunktowana trasaPunkt) {
        return trasaPunktowanaService.addTrasaPunkt(trasaPunkt);
    }
}
