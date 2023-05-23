package com.vetrix.projetBD.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhotoRepository extends JpaRepository<PhotoDto, Long> {
    @Query("select i from PhotoDto i where i.codePro = ?1 ")
	List<PhotoDto> findByCod(int code);
}
