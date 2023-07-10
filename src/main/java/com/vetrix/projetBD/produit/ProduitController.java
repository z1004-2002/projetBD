package com.vetrix.projetBD.produit;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produit")
@CrossOrigin("*")
@Tag(name = "Produit")
public class ProduitController {
    private final ProduitService service;
    private final ProduitRepository repository;

    public ProduitController(ProduitService service, ProduitRepository repository) {
        this.service = service;
        this.repository = repository;
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
    @GetMapping(path = "/nombre")
    public int getNombre(){
        return (int) repository.count();
    }
    @GetMapping(path = "/nombre/{cat}")
    public int getCatNombre(@PathVariable Integer cat){
        return Math.toIntExact(repository.catCount(cat));
    }
    @GetMapping(path = "/categorie/{idCat}")
    public List<Produit> getByCategorie(@PathVariable int idCat){
        return repository.getByCat(idCat);
    }
    @PutMapping(path = "/update/{id}")
    public Produit updatePro(@PathVariable int id,@RequestBody Produit produit){
        return service.updateProd(id,produit);
    }

    @PutMapping(path = "/update/quantity/add/{id}")
    public void addQte(@PathVariable("id") int id,@RequestBody int numberToAdd){
        service.addQte(id, numberToAdd);
    }

    @PutMapping(path = "/update/quantity/sub/{id}")
    public void subQte(@PathVariable("id") int id,@RequestBody int numberToAdd){
        service.subQte(id, numberToAdd);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deletePro(@PathVariable int id){
        service.deleteProd(id);
    }
}