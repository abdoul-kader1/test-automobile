package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitsRepositorie extends JpaRepository<Produits,Integer> {
    Produits findById(int id);
}
