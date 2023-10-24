package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.repositorys.ClientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientsServices {
    private final ClientsRepository clientsRepository;

    public ClientsServices(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void ajouterClients(Clients clients){
        Clients clientBd = this.clientsRepository.findByEmail(clients.getEmail());
        if(clientBd == null){
            this.clientsRepository.save(clients);
        }
    }
    public List<Clients> recupListClients(){
        return this.clientsRepository.findAll();
    }
    public Clients unClient(int id){
        Optional<Clients>optionalClients = this.clientsRepository.findById(id);
        return optionalClients.orElse(null);
    }
    public Clients lireOuCree(Clients clientsAcree){
        Clients clientBd = this.clientsRepository.findByEmail(clientsAcree.getEmail());
        if(clientBd == null){
           clientBd = this.clientsRepository.save(clientsAcree);
        }
        return clientBd;
    }
    //modifier les informations du clients
    public void modifierInfoClients(int id,Clients clients){
        Clients clientsBd = this.unClient(id);
        if(clientsBd.getId()==clients.getId()){
            clientsBd.setEmail(clients.getEmail());
            this.clientsRepository.save(clientsBd);
        }else {
            System.out.println("non");
        }
    }
}
