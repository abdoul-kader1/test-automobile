package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.repositorys.ClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsServices {
    ClientsRepository clientsRepository;

    public ClientsServices(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void ajouterClients(Clients clients){
        this.clientsRepository.save(clients);
    }
}
