package com.vetrix.projetBD.facture;

import com.vetrix.projetBD.lineFacture.ProdFac;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FactureDto {
    private int idFac;
    private Date dateFac;
    private BigDecimal remise;
    private BigDecimal montant;
    private String tel;
    private byte typeFac;
    private int idCaissiere;
    private BigDecimal capital;
    private BigDecimal tva;
    private List<ProdFac> produits;

    public FactureDto(int idFac, Date dateFac, BigDecimal remise, BigDecimal montant, String tel, byte typeFac, int idCaissiere, BigDecimal capital, BigDecimal tva) {
        this.idFac = idFac;
        this.dateFac = dateFac;
        this.remise = remise;
        this.montant = montant;
        this.tel = tel;
        this.typeFac = typeFac;
        this.idCaissiere = idCaissiere;
        this.capital = capital;
        this.tva = tva;
    }
}
