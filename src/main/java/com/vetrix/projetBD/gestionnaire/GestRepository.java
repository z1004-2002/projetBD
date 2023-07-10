package com.vetrix.projetBD.gestionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestRepository extends JpaRepository<Gestionnaire,Integer> {
    Gestionnaire findByLogin(String login);
}
