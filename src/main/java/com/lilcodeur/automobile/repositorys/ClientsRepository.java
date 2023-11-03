package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.modeles.NomPrenom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients,Integer>{
    //recuperer un client en fonction de son email
    Clients findByEmail(String email);
    @Query(value = "INSERT INTO clients (nom,prenom,email,mdp) VALUES(:nom,:prenom,:email,:mdp)",nativeQuery = true)
    void createClient(
            @Param("nom")String nom,@Param("prenom")String prenom,@Param("email")String email,@Param("mdp")String mdp
    );
    @Query(value = "SELECT nom as nom,prenom as prenom FROM clients",nativeQuery = true)
    List<NomPrenom> findNomAndPrenom();
}
