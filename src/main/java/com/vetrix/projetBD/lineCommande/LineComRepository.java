package com.vetrix.projetBD.lineCommande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LineComRepository extends JpaRepository<LineCommande,Integer>{
    @Query("select l from LineCommande l where l.idCommande = ?1")
    List<LineCommande> getLineByCommand(int idCommande);
}
