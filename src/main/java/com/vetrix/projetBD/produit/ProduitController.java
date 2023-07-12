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


    /*@GetMapping
    public List<ProduitDto> getProduits(){
        return service.getProduit();
    }*/

    @GetMapping
    public APIResoponse<List<ProduitDto>> getProduits(){
        List<ProduitDto> allProduct = service.getProduit();
        return new APIResoponse<>(allProduct.size(),allProduct);
    }

    @GetMapping("/pagination/{offset}/{sizePage}")
    public APIResoponse<List<ProduitDto>> getPro(@PathVariable int offset,@PathVariable int sizePage){
        List<ProduitDto> allProduct = service.getProductPagination(offset, sizePage);
        return new APIResoponse<>(allProduct.size(),allProduct);
    }
    @GetMapping("/paginationSort/{offset}/{sizePage}/{field}")
    public APIResoponse<List<ProduitDto>> getProPageSort(@PathVariable int offset,@PathVariable int sizePage,@PathVariable String field){
        List<ProduitDto> allProduct = service.getProductPaginationSort(offset, sizePage,field);
        return new APIResoponse<>(allProduct.size(),allProduct);
    }
    @GetMapping(path = "/categorie/{idCat}/pagination/{offset}/{sizePage}")
    public List<Produit> getByCategoriePagination(@PathVariable int idCat){
        return repository.getByCat(idCat);
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
    public void addQte(@PathVariable("id") int id,@RequestParam(name = "number") int numberToAdd, @RequestParam(name = "idGest") int idGest){
        service.addQte(id, numberToAdd, idGest);
    }

    @PutMapping(path = "/update/quantity/sub/{id}")
    public void subQte(@PathVariable("id") int id,@RequestParam(name = "number") int numberToSub, @RequestParam(name = "idGest") int idGest){
        service.subQte(id, numberToSub, idGest);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deletePro(@PathVariable int id){
        service.deleteProd(id);
    }
}