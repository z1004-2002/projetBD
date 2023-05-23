package com.vetrix.projetBD.commande;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
@Tag(name = "Commande")
public class CommandeController {
    private final CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }
    @GetMapping
    public List<CommandeDto> getAllCommande() throws IllegalAccessException {
        return service.getAllCom();
    }
    @GetMapping("/{id}")
    public CommandeDto getCommandeById(@PathVariable int id) throws IllegalAccessException {
        return service.getCom(id);
    }
    @PostMapping(path ="/add")
    public Commande addCommande(@RequestBody CommandeDto commandeDto) throws IllegalAccessException {
        return service.addCom(commandeDto);
    }
    @PutMapping(path ="/update/{id}")
    public Commande updateCommande(@PathVariable int id,@RequestBody Commande commande) throws IllegalAccessException {
        return service.updateCommande(id,commande);
    }
    @DeleteMapping(path ="/delete/{id}")
    public void deleteCommande(@PathVariable int id) throws IllegalAccessException {
        service.deleteCom(id);
    }
}
