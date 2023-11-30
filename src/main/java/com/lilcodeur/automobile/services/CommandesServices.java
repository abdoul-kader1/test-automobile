package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.DTO.CommandesDto;
import com.lilcodeur.automobile.modeles.Commandes;
import com.lilcodeur.automobile.modeles.Livraisons;
import com.lilcodeur.automobile.modeles.Produits;
import com.lilcodeur.automobile.modeles.Utilisateurs;
import com.lilcodeur.automobile.repositorys.CommandesRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CommandesServices {
    private CommandesRepository commandesRepository;
    private UtilisateursServices utilisateursServices;
    private ProduitsServices produitsServices;
    private LivraisonsServices livraisonsServices;
    //Ajouter la commande d'un client
    public void add(Commandes commandes){
        Utilisateurs bdUtilisateur = utilisateursServices.obtenirUtilisateur(commandes.getUtilisateurs().getId());
        Produits bdProduit = produitsServices.obtenirProduits(commandes.getProduits().getId());
        Livraisons bdLivraison = livraisonsServices.obtenirLivraison(commandes.getLivraisons().getId());
        //changer la valeur de la commande obtenir depuis le controller
        commandes.setUtilisateurs(bdUtilisateur);
        commandes.setProduits(bdProduit);
        commandes.setLivraisons(bdLivraison);
        commandesRepository.save(commandes);
    }
    //obtenir la liste des livraisons
    public List<Commandes> listeCommandes(){
        return  commandesRepository.findAll();
    }
    //mise a jour d'une commande
    public void updateCommandes(int id,Commandes commandes){
        Commandes commandesBd = commandesRepository.findById(id);
        if(Objects.equals(commandesBd.getId(),commandes.getId())){
            commandesBd.setMode_paiement(commandes.getMode_paiement());
            commandesRepository.save(commandesBd);
        }else{
            throw new EntityNotFoundException("id commandes invalide");
        }
    }
    public List<Commandes> obtenirCommandesDuneLivraison(int id){
        return commandesRepository.findCommandeId(id);
    }
    //obtenir la commandes sans le produit et le client
    public Stream<CommandesDto>streamCommandes(int id){
        return commandesRepository.findCommandeId(id).stream().map(commandes->new CommandesDto(commandes.getId(),commandes.getDate(),commandes.getMode_paiement(),commandes.getLivraisons().getLieu()));
    }
}
