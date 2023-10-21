package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.services.ClientsServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("clients")
public class ClientsController {
    ClientsServices clientsServices;

    public ClientsController(ClientsServices clientsServices) {
        this.clientsServices = clientsServices;
    }

    @PostMapping(value = "ajouter",consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void ajouterClients(@RequestBody Clients clients){
        this.clientsServices.ajouterClients(clients);
    }
}
