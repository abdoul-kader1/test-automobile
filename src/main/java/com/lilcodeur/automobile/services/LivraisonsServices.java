package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.modeles.Commandes;
import com.lilcodeur.automobile.modeles.Livraisons;
import com.lilcodeur.automobile.repositorys.LivraisonsRepositorie;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class LivraisonsServices {
    private LivraisonsRepositorie livraisonsRepositorie;
    //ajouter une livraison dans la bdd
    public void add(Livraisons livraisons){
        livraisonsRepositorie.save(livraisons);
    }
    //obtenir la livraison en fonction de id
    public Livraisons obtenirLivraison(int id){
       Livraisons livraisonsBdd = livraisonsRepositorie.findById(id);
       if(livraisonsBdd == null){
           throw new EntityNotFoundException("id livraison invalide");
       }else{
           return livraisonsBdd;
       }
    }
    // obtenir la liste des livraisons
    public List<Livraisons> listeLivraions(){
        return livraisonsRepositorie.findAll();
    }
    //mettre a jour les informations d'une livraison
    public void updateInfoLivraison(int id,Livraisons livraisons){
        Livraisons livraisonsBd = obtenirLivraison(id);
        if(Objects.equals(livraisonsBd.getId(),livraisons.getId())){
            livraisonsBd.setLieu(livraisons.getLieu());
            livraisonsRepositorie.save(livraisonsBd);
        }else{
            throw new EntityNotFoundException("id livraison incorrecte");
        }
    }
    //supprimer une livraisons dans la base de donnée
    public void deleteLivraison(int id){
        livraisonsRepositorie.deleteById(id);
    }

}
