package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.modeles.Voitures;
import com.lilcodeur.automobile.services.VoituresServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "voitures",produces = APPLICATION_JSON_VALUE)
public class VoitureController {
    private final VoituresServices voituresServices;

    public VoitureController(VoituresServices voituresServices) {
        this.voituresServices = voituresServices;
    }
    //affecter un véhicule a un clients
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "ajouter",consumes = APPLICATION_JSON_VALUE)
    public void ajouterVoiture(@RequestBody Voitures voiture){
        this.voituresServices.ajouterVoiture(voiture);
    }

    //lister tous les véhicules affectés
    @GetMapping(value = "listes")
    public @ResponseBody List<Voitures>listeVoitureAffecter(@RequestParam(required = false) String marque){
        return this.voituresServices.listeVoitures(marque);
    }
    //supprimer la voitures d'un client
    @DeleteMapping(path = "supprimer/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void supprimerVoiture(@PathVariable int id){
        this.voituresServices.supprimerVoiture(id);
    }
    @GetMapping(path = "client/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Voitures>voituresClient(@PathVariable int id){
        return this.voituresServices.voituresClients(id);
    }

}
