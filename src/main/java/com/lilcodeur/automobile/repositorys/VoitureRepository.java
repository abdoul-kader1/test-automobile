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
    //requetes native pour ajouter une voiture dans la base de donnee
    @Query(value = "INSERT INTO voitures (marque,modele,couleur,client) VALUES(:marque,:modele,:couleur,:client)",nativeQuery = true)
    public void nativeAddVoitures(
            @Param("marque")String marque,@Param("modele")String modele,
            @Param("couleur")String couleur,@Param("client")int client
    );
    //modifier la marque et le modele de voiture d'un clients
    @Query(value = "UPDATE voitures SET marque=:marque,modele=:modele WHERE client=:idClient AND couleur=:couleur",nativeQuery = true)
    public void modifierMarqueModele(
            @Param("marque")String marque,@Param("modele")String modele,@Param("idClient")int idClient,
            @Param("couleur")String couleur
    );
}
