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

    public Gestionnaire getGestByLoggin(String loggin){
        Gestionnaire gest = repository.findByLogin(loggin)
                .orElseThrow(() ->new IllegalArgumentException("not found gestionnaire"));

        return gest;
    }

    public Gestionnaire updateGest(int id, Gestionnaire gestionnaire){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("not found gestionnaire");
        repository.findById(id).map(g -> {
            g.setNomGest(gestionnaire.getNomGest());
            g.setActif(gestionnaire.getActif());
            g.setLogin(gestionnaire.getLogin());
            g.setPwd(gestionnaire.getPwd());
            g.setTypeGest(gestionnaire.getTypeGest());
            return repository.save(g);
        });
        return gestionnaire;
    }

    public Gestionnaire findByLogin(String login){
        return repository.findByLogin(login);
    }

    public void deleteGest(int id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("not found gestionnaire");
        repository.deleteById(id);
    }
}
