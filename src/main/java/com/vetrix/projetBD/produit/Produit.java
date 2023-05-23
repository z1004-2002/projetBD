package com.vetrix.projetBD.produit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produit")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produit {
    @Id
    private int codePro;
    private String nomPro;
    private BigDecimal prix;
    private int qte;
    private String description;
    private String codeFour;
    private int actif;
    private int idCategorie;
    private Date dateInsertion;
    private BigDecimal prixAchat;
    private BigDecimal pourcentage;
    private int promo;
    private int size1;
    private int size2;
    private int age;
}
