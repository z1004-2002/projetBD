package com.vetrix.projetBD.categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategirieRepository extends JpaRepository<Categotie,Integer> {
}
