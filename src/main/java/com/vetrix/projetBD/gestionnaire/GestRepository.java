package com.vetrix.projetBD.gestionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GestRepository extends JpaRepository<Gestionnaire,Integer> {
    Gestionnaire findByLogin(String login);
}
