package com.vetrix.projetBD.gestionStock;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
@CrossOrigin("*")
@Tag(name = "stock")
public class GestionStockController {

    private GestionStockService service;

    public GestionStockController(GestionStockService service) {
        this.service = service;
    }

    @GetMapping
    public List<GestionStockDto> getStock(){
        return service.getStock();
    }

}
