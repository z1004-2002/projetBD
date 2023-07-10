package com.vetrix.projetBD.categorie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "categorie")
public class Categotie {
    @Id
    private Integer idCat;
    private String nomCat;
}
