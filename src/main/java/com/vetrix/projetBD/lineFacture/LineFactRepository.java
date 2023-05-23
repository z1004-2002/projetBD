package com.vetrix.projetBD.lineFacture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LineFactRepository extends JpaRepository<LineFacture,Integer> {
    @Query("select l from LineFacture l where l.idFac = ?1")
    List<LineFacture> getLineByFacture(int idFac);
}
