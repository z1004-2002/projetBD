package com.vetrix.projetBD.gestionStock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gestionstock")
public class GestionStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStock;
    private int qte;
    private LocalDateTime dateStock;
    private int operation;
    private int idGest;
    private int codePro;

    public GestionStock(int qte, LocalDateTime dateStock, int operation, int idGest, int codePro) {
        this.qte = qte;
        this.dateStock = dateStock;
        this.operation = operation;
        this.idGest = idGest;
        this.codePro = codePro;
    }
}
