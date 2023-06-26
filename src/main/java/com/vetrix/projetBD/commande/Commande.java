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
    private int idCom;
    private Timestamp dateCommande;
    private BigDecimal montant;
    private String nomClient;
    private String mobile;
    private String adresse;
    private String commentaire;
    private byte livre;
}
