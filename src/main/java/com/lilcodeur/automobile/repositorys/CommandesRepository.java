package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandesRepository extends JpaRepository<Commandes,Integer> {
    Commandes findById(int id);
    @Query(value = "SELECT * FROM commandes WHERE id_livraison = :id",nativeQuery = true)
    List<Commandes> findCommandeId(@Param("id") int id);
}
