package com.vetrix.projetBD.categorie;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
@Tag(name = "Categorie")
public class CategorieController {
    private final CategorieService service;
    public CategorieController(CategorieService service) {
        this.service = service;
    }
    @GetMapping
    public List<Categotie> getCategorie(){
        return service.getAllCathegorie();
    }
    @GetMapping(path = "/{id}")
    public Optional<Categotie> getCat(@PathVariable int id) throws IllegalAccessException {
        return service.getCat(id);
    }
    @PostMapping(path = "/add")
    public Categotie addCat(@RequestBody Categotie categotie){
        return service.addCat(categotie);
    }
    @PutMapping(path = "/update/{id}")
    public Categotie updateCat(@PathVariable int id, @RequestBody Categotie categotie) throws IllegalAccessException {
        service.updateCat(id, categotie);
        return categotie;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteCat(@PathVariable int id) throws IllegalAccessException {
        service.deleteCat(id);
        return "deleted";
    }
}
