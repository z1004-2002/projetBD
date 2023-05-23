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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCat;
    private String nomCat;
}
