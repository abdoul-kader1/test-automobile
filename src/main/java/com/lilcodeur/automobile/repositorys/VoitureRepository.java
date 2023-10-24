package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Voitures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voitures,Integer> {
    List<Voitures> findByMarque(String marque);
    @Query(value = "SELECT * FROM voitures where client=:kader",nativeQuery = true)
    List<Voitures>voitureClient(@Param("kader") int id);
}
