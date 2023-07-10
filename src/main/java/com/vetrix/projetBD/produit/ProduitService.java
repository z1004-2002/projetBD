package com.vetrix.projetBD.produit;

import com.vetrix.projetBD.categorie.CategirieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProduitService {
    private final ProduitRepository repository;
    private final CategirieRepository categirieRepository;

    public ProduitService(ProduitRepository repository, CategirieRepository categirieRepository) {
        this.repository = repository;
        this.categirieRepository = categirieRepository;
    }
    public ProduitDto getProduit(int id){
        ProduitDto produitDto = new ProduitDto();
        Produit prod = repository.findById(id).get();

        produitDto.setCodePro(prod.getCodePro());
        produitDto.setNomPro(prod.getNomPro());
        produitDto.setPrix(prod.getPrix());
        produitDto.setQte(prod.getQte());
        produitDto.setDescription(prod.getDescription());
        produitDto.setCodeArrivage(prod.getCodeArrivage());
        produitDto.setActif(prod.getActif());
        produitDto.setCategorie(categirieRepository.findById(prod.getIdCategorie()).get());
        produitDto.setDateInsertion(prod.getDateInsertion());
        produitDto.setPrixAchat(prod.getPrixAchat());
        produitDto.setPourcentage(prod.getPourcentage());
        produitDto.setPromo(prod.getPromo());
        produitDto.setSize1(prod.getSize1());
        produitDto.setSize2(prod.getSize2());
        produitDto.setTypeSize(prod.getTypeSize());
        return produitDto;
    }

    public List<ProduitDto> getProduit(){
        List<ProduitDto> produitDtos = new ArrayList<>();
        for (Produit prod : repository.findAll()){
            produitDtos.add(getProduit(prod.getCodePro()));
        }
        return produitDtos;
    }

    public int genId(){
        Random rand = new Random();
        int min = 100000;
        int max = 999999;
        return rand.nextInt((max - min) + 1) + min;
    }
    public Produit addProd(Produit produit){
        boolean test = false;
        int id = genId();
        while(!test){
            if (!repository.existsById(id)){
                test = true;
            }else {
                id = genId();
            }
        }
        produit.setCodePro(id);
        return repository.save(produit);
    }
    public Produit updateProd(int id, Produit prod){
        if(!repository.existsById(id))
            throw new IllegalStateException("Product not found");
        repository.findById(id).map(p ->{
            p.setCodePro(prod.getCodePro());
            p.setNomPro(prod.getNomPro());
            p.setPrix(prod.getPrix());
            p.setQte(prod.getQte());
            p.setDescription(prod.getDescription());
            p.setCodeArrivage(prod.getCodeArrivage());
            p.setActif(prod.getActif());
            p.setIdCategorie(prod.getIdCategorie());
            p.setDateInsertion(prod.getDateInsertion());
            p.setPrixAchat(prod.getPrixAchat());
            p.setPourcentage(prod.getPourcentage());
            p.setPromo(prod.getPromo());
            p.setSize1(prod.getSize1());
            p.setSize2(prod.getSize2());
            p.setTypeSize(prod.getTypeSize());
            return repository.save(p);
        } );
        return prod;
    }

    public void addQte(int id, int numberToAdd){
        Produit prod = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product not found"));
        prod.setQte(prod.getQte() + numberToAdd);
        repository.save(prod);
    }

    public void subQte(int id, int numberToSub){
        Produit prod = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product not found"));
        prod.setQte(prod.getQte() - numberToSub);
        repository.save(prod);
    }

    public void deleteProd(int id){
        if(!repository.existsById(id))
            throw new IllegalStateException("Product not found");
        repository.deleteById(id);
    }
}
