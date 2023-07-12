package com.vetrix.projetBD.lineFacture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lignefacture")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LineFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLFac")
    private int idLFac;
    private int codePro;
    private int idFac;
    private int prix;
    private int qte;

    public LineFacture(int codePro, int idFac, int prix, int qte) {
        this.codePro = codePro;
        this.idFac = idFac;
        this.prix = prix;
        this.qte = qte;
    }
}
