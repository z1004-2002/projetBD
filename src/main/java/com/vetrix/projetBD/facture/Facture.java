package com.vetrix.projetBD.facture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "facture")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFac;
    private Date dateFac;
    private BigDecimal remise;
    private BigDecimal montant;
    private String tel;
    private byte typeFac;
    private int idCaissiere;
    private BigDecimal capital;
    private BigDecimal tva;

}
