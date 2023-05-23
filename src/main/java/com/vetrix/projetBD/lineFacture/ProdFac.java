package com.vetrix.projetBD.lineFacture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdFac {
    private int codePro;
    private int idFac;
    private int prix;
    private int qte;
}
