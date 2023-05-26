package com.vetrix.projetBD.facture;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/facture")
@Tag(name = "Facture")
@CrossOrigin("*")
public class FactureController {
    private final FactureService service;

    public FactureController(FactureService service) {
        this.service = service;
    }
    @GetMapping
    public List<FactureDto> getFac(){
        return service.getFac();
    }
    @GetMapping(path = "/{id}")
    public FactureDto getFact(@PathVariable("id") int id){
        return service.getFac(id);
    }
    @PostMapping(path = "/add")
    public Facture addFact(@RequestBody FactureDto factureDto){
        return service.addFac(factureDto);
    }
    @PutMapping(path = "/update/{id}")
    public Facture updateFact(@PathVariable int id,@RequestBody Facture facture){
        return service.updateFac(id, facture);
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteFact(@PathVariable int id){
        service.deleteFac(id);
        return "deleted";
    }
}
