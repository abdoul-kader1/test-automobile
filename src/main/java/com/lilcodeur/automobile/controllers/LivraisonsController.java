package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.modeles.Commandes;
import com.lilcodeur.automobile.modeles.Livraisons;
import com.lilcodeur.automobile.services.LivraisonsServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livraisons")
@AllArgsConstructor
public class LivraisonsController {
    private LivraisonsServices livraisonsServices;

    //ajputer une livraison dans la bdd
    @PostMapping(value = "add")
    public void add(@RequestBody Livraisons livraisons){
        livraisonsServices.add(livraisons);
    }
    //lister les livraisons
    @GetMapping(value = "listes")
    @ResponseStatus(HttpStatus.OK)
    public List<Livraisons>listeLivraisons(){
        return livraisonsServices.listeLivraions();
    }
    //mises a jour de livraison
    @PutMapping(path = "{id}/modifier")
    @ResponseStatus(HttpStatus.OK)
    public void updateLivraison(@PathVariable int id,@RequestBody Livraisons livraisons){
        livraisonsServices.updateInfoLivraison(id,livraisons);
    }
    //supprimer une livraison
    @DeleteMapping(path = "{id}/supprimer")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLivraison(@PathVariable int id){
        livraisonsServices.deleteLivraison(id);
    }

}
