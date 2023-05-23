package com.vetrix.projetBD.commande;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;
    private Timestamp dateCommande;
    private BigDecimal montant;
    private String nom_client;
    private String telephone_client;
    private String adresse_client;
    private String commentaire;
    private byte livre;
}
