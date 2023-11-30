package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Commandes;
import com.lilcodeur.automobile.modeles.Livraisons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivraisonsRepositorie extends JpaRepository<Livraisons,Integer> {
    Livraisons findById(int id);

}
