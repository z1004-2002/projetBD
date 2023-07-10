package com.vetrix.projetBD.gestionStock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionStockRepo extends JpaRepository<GestionStock, Integer> {

}
