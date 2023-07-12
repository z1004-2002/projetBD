package com.vetrix.projetBD.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    @Query("select count(*) from Produit")
    long count();

    @Query("select count(p) from Produit p where p.idCategorie = ?1")
    Long catCount(int cat);

    @Query("Select p from Produit p where p.idCategorie = ?1 ORDER BY p.qte DESC")
    List<Produit> getByCat(int idCat);
}
