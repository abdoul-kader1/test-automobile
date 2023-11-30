package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.modeles.Produits;
import com.lilcodeur.automobile.repositorys.ProduitsRepositorie;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProduitsServices {
    private ProduitsRepositorie produitsRepositorie;
    public void add(Produits produits){
        produitsRepositorie.save(produits);
    }
    public Produits obtenirProduits(int id){
        Produits produitsBdd = produitsRepositorie.findById(id);
        if(produitsBdd == null){
            throw new EntityNotFoundException("Id produits invalide");
        }else{
            return produitsBdd;
        }
    }
}
