package com.vetrix.projetBD.produit;

import com.vetrix.projetBD.categorie.Categotie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProduitDto {
    private int codePro;
    private String nomPro;
    private BigDecimal prix;
    private int qte;
    private String description;
    private String codeArrivage;
    private int actif;
    private Categotie categorie;
    private Date dateInsertion;
    private BigDecimal prixAchat;
    private BigDecimal pourcentage;
    private int promo;
    private int size1;
    private int size2;
    private int typeSize;
}
