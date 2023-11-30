package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.DTO.CommandesDto;
import com.lilcodeur.automobile.modeles.Commandes;
import com.lilcodeur.automobile.services.CommandesServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("commandes")
@AllArgsConstructor
public class CommandesController {
    private CommandesServices commandesServices;
    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void add(@RequestBody Commandes commandes){
        commandesServices.add(commandes);
    }
    // listes des commandes
    @GetMapping(value = "listes")
    @ResponseStatus(HttpStatus.OK)
    public List<Commandes> listeCommandes(){
        return commandesServices.listeCommandes();
    }
    //modifier mode de paiement de la commande
    @PutMapping(path = "{id}/modifier")
    @ResponseStatus(HttpStatus.OK)
    public void updateModePaiement(@PathVariable int id,@RequestBody Commandes commandes){
        commandesServices.updateCommandes(id,commandes);
    }
    //obtenir les commandes d'une livraison
    @GetMapping(path = "{id}")
    public List<Commandes> commandesDuneLivraison(@PathVariable int id){
        return commandesServices.obtenirCommandesDuneLivraison(id);
    }
    //obtenir la commande avec d'autre propriete
    @GetMapping("{id}/other")
    public Stream<CommandesDto> commandesDtoStream(@PathVariable int id){
        return commandesServices.streamCommandes(id);
    }
}
