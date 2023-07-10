package com.vetrix.projetBD.categorie;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    private final CategirieRepository repository;

    public CategorieService(CategirieRepository repository) {
        this.repository = repository;
    }
    public List<Categotie> getAllCathegorie(){
        return repository.findAll();
    }
    public Optional<Categotie> getCat(int id) throws IllegalAccessException {
        if (!repository.existsById(id))
            throw new IllegalAccessException("categotie not found");
        return repository.findById(id);
    }
    public Categotie updateCat(Integer id, Categotie categotie) throws IllegalAccessException {
        Categotie existingCat = repository.findById(id).get();
        BeanUtils.copyProperties(categotie, existingCat, "id");
        return repository.save(existingCat);
    }
    public void deleteCat(int id) throws IllegalAccessException {
        if (!repository.existsById(id))
            throw new IllegalAccessException("categotie not found");
        repository.deleteById(id);
    }
    public Categotie addCat(Categotie categotie){
        return repository.save(categotie);
    }
}
