package com.vetrix.projetBD.gestionStock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GestionStockDto {
    private int idStock;
    private int qte;
    private LocalDateTime dateStock;
    private int operation;
    private int idGest;
    private int codePro;
}
