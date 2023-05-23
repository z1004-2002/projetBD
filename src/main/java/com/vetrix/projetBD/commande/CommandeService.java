package com.vetrix.projetBD.commande;

import com.vetrix.projetBD.lineCommande.LineComRepository;
import com.vetrix.projetBD.lineCommande.LineCommande;
import com.vetrix.projetBD.lineCommande.ProdCom;
import com.vetrix.projetBD.produit.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService {
    private final CommandeRepository repository;
    private final LineComRepository lineComRepository;

    public CommandeService(CommandeRepository repository, LineComRepository lineComRepository) {
        this.repository = repository;
        this.lineComRepository = lineComRepository;
    }
    public List<CommandeDto> getAllCom() throws IllegalAccessException {
        List<CommandeDto> commandeDtos = new ArrayList<>();
        List<Commande> commandes = repository.findAll();
        for (Commande comm:commandes){
            commandeDtos.add(getCom(comm.getIdCommande()));
        }
        return commandeDtos;
    }
    public CommandeDto getCom(int id) throws IllegalAccessException {
        Commande commande = repository.findById(id).get();
        CommandeDto commandeDto = new CommandeDto();

        commandeDto.setIdCommande(commande.getIdCommande());
        commandeDto.setDateCommande(commande.getDateCommande());
        commandeDto.setMontant(commande.getMontant());
        commandeDto.setNom_client(commande.getNom_client());
        commandeDto.setTelephone_client(commande.getTelephone_client());
        commandeDto.setAdresse_client(commande.getAdresse_client());
        commandeDto.setCommentaire(commande.getCommentaire());
        commandeDto.setLivre(commande.getLivre());

        List<ProdCom> prodComs = new ArrayList<>();

        List<LineCommande> lineCommandes = lineComRepository.getLineByCommand(id);
        for (LineCommande lineCommande : lineCommandes){
            prodComs.add(
                    new ProdCom(
                        lineCommande.getCodePro(),
                        lineCommande.getQuantite(),
                        lineCommande.getTaille(),
                        lineCommande.getCouleur(),
                        lineCommande.getDisponible()
                    )
            );
        }
        commandeDto.setProduits(prodComs);
        return commandeDto;
    }
    public Commande addCom(CommandeDto commandeDto){
        Commande commande = new Commande(
                commandeDto.getIdCommande(),
                commandeDto.getDateCommande(),
                commandeDto.getMontant(),
                commandeDto.getNom_client(),
                commandeDto.getTelephone_client(),
                commandeDto.getAdresse_client(),
                commandeDto.getCommentaire(),
                commandeDto.getLivre()
        );
        Commande com = repository.save(commande);
        for (ProdCom prodCom: commandeDto.getProduits()){
            lineComRepository.save(new LineCommande(
                    com.getIdCommande(),
                    prodCom.getCodePro(),
                    prodCom.getQuantite(),
                    prodCom.getTaille(),
                    prodCom.getCouleur(),
                    prodCom.getDisponible()
            ));
        }
        return com;
    }
    public Commande updateCommande(int id, Commande commande) throws IllegalAccessException {
        if (!repository.existsById(id))
            throw new IllegalAccessException("Commande not found");
        repository.findById(id).map(c->{
            c.setDateCommande(commande.getDateCommande());
            c.setMontant(commande.getMontant());
            c.setCommentaire(commande.getCommentaire());
            c.setNom_client(commande.getNom_client());
            c.setAdresse_client(commande.getAdresse_client());
            c.setTelephone_client(commande.getTelephone_client());
            c.setLivre(commande.getLivre());
            return repository.save(c);
        });
        return commande;
    }
    public void deleteCom(int id) throws IllegalAccessException {
        if (!repository.existsById(id))
            throw new IllegalAccessException("Commande not found");
        repository.deleteById(id);
    }
}
