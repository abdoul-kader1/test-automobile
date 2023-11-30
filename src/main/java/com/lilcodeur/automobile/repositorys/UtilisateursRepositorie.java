package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursRepositorie extends JpaRepository<Utilisateurs,Integer> {
    //Selectionner un utilisateur en fonction de son email
     Utilisateurs findByEmail(String email);
     Utilisateurs findById(int id);

}
