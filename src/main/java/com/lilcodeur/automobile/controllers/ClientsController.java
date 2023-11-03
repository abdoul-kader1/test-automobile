package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.modeles.NomPrenom;
import com.lilcodeur.automobile.services.ClientsServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("clients")
public class ClientsController {
    private final ClientsServices clientsServices;

    public ClientsController(ClientsServices clientsServices) {
        this.clientsServices = clientsServices;
    }

    @PostMapping(value = "ajouter",consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void ajouterClients(@RequestBody Clients clients){
        this.clientsServices.ajouterClients(clients);
    }
    @GetMapping(value = "liste",produces = APPLICATION_JSON_VALUE)
    public List<Clients> recupListClients(){
        return this.clientsServices.recupListClients();
    }
    @GetMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public Clients unClient(@PathVariable int id){
        return this.clientsServices.unClient(id);
    }
    //modifier les informations du client
    @PutMapping(path = "modifier/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifierInfoClients(@PathVariable int id,@RequestBody Clients clients){
        this.clientsServices.modifierInfoClients(id,clients);
    }
    //juste un teste
    @PostMapping(value = "testClient")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClientsTest(@RequestBody Clients clients){
        this.clientsServices.testClient(clients);
    }
    @GetMapping(value = "nom/prenom",produces = APPLICATION_JSON_VALUE)
    public List<NomPrenom> getNomPrenomClients(){
        return this.clientsServices.getNomPrenomClients();
    }
}
