package com.vetrix.projetBD.lineCommande;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lignecommande")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LineCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLineCom;
    private int idCommande;
    private int codePro;
    private int quantite;
    private String taille;
    private String couleur;
    @Column(name = "disponibe")
    private int disponible;

    public LineCommande(int idCommande, int codePro, int quantite, String taille, String couleur, int disponible) {
        this.idCommande = idCommande;
        this.codePro = codePro;
        this.quantite = quantite;
        this.taille = taille;
        this.couleur = couleur;
        this.disponible = disponible;
    }
}
