package com.vetrix.projetBD.commande;

import com.vetrix.projetBD.lineCommande.ProdCom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommandeDto {
    private int idCommande;
    private Timestamp dateCommande;
    private BigDecimal montant;
    private String nom_client;
    private String telephone_client;
    private List<ProdCom> produits;
    private String adresse_client;
    private String commentaire;
    private byte livre;
}
