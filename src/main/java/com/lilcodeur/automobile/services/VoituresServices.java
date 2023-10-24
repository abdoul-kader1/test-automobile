package com.lilcodeur.automobile.services;
import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.modeles.Voitures;
import com.lilcodeur.automobile.repositorys.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoituresServices {
    private final VoitureRepository voitureRepository;
    private final ClientsServices clientsServices;

    public VoituresServices(VoitureRepository voitureRepository, ClientsServices clientsServices) {
        this.voitureRepository = voitureRepository;
        this.clientsServices = clientsServices;
    }

    //affecter une voiture a un clients
    public void ajouterVoiture(Voitures voitures){
        Clients clients = this.clientsServices.lireOuCree(voitures.getClient());
        voitures.setClient(clients);
        this.voitureRepository.save(voitures);
    }
    //afficher la liste des voitures affectées
    public List<Voitures>listeVoitures(String marque){
        if(marque==null){
            return this.voitureRepository.findAll();
        }else{
            return this.voitureRepository.findByMarque(marque);
        }
    }
    //supprimer l'affection d'une voitures a un client
    public void supprimerVoiture(int id){
        this.voitureRepository.deleteById(id);
    }
    public List<Voitures>voituresClients(int id){
        return this.voitureRepository.voitureClient(id);
    }
}
