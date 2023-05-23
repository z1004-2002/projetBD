package com.vetrix.projetBD.produit;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produit")
@Tag(name = "Produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ProduitDto getProduit(@PathVariable int id){
        return service.getProduit(id);
    }
    @GetMapping
    public List<ProduitDto> getProduits(){
        return service.getProduit();
    }
    @PostMapping(path = "/add")
    public Produit addPro(@RequestBody Produit produit){
        return service.addProd(produit);
    }
    @PutMapping(path = "/update/{id}")
    public Produit updatePro(@PathVariable int id,@RequestBody Produit produit){
        return service.updateProd(id,produit);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deletePro(@PathVariable int id){
        service.deleteProd(id);
    }
}