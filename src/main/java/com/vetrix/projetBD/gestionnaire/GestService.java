package com.vetrix.projetBD.gestionnaire;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestService{
    private final GestRepository repository;
    public GestService(GestRepository repository) {
        this.repository = repository;
    }

    public Gestionnaire addGest(Gestionnaire gestionnaire){
        return repository.save(gestionnaire);
    }
    public List<Gestionnaire> getGest(){
        return repository.findAll();
    }
    public Gestionnaire getGest(int id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("not found gestionnaire");
        return repository.findById(id).get();
    }
    public Gestionnaire updateGest(int id, Gestionnaire gestionnaire){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("not found gestionnaire");
        repository.findById(id).map(g -> {
            g.setNomGes(gestionnaire.getNomGes());
            g.setActif(gestionnaire.getActif());
            g.setLogin(gestionnaire.getLogin());
            g.setPwd(gestionnaire.getPwd());
            g.setTypeGes(gestionnaire.getTypeGes());
            return repository.save(g);
        });
        return gestionnaire;
    }
    public void deleteGest(int id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("not found gestionnaire");
        repository.deleteById(id);
    }
}
