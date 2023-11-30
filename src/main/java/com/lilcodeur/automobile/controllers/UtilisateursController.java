package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.modeles.Utilisateurs;
import com.lilcodeur.automobile.services.UtilisateursServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utilisateurs")
@AllArgsConstructor
public class UtilisateursController {
    private final UtilisateursServices utilisateursServices;
    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    //ajouter un utilisateur dans la base de donnée
    public void add(@RequestBody Utilisateurs utilisateurs){
        this.utilisateursServices.add(utilisateurs);
    }

    //obtenir la liste des utilisateurs
    @GetMapping(value = "listes")
    @ResponseStatus(HttpStatus.OK)
    public List<Utilisateurs> listeUtilisateur(){
        return utilisateursServices.listeUtilisateur();
    }
    //Modifiier l'email et le mot de passe de l'utilisateur
    @PutMapping(path = "{id}/modifier")
    @ResponseStatus(HttpStatus.OK)
    public void updateInfoUser(@PathVariable int id,@RequestBody Utilisateurs utilisateurs){
        utilisateursServices.miseAjourInfoUtilisateur(id,utilisateurs);
    }
    //supprimer un utilisateur dans la bdd
    @DeleteMapping(path = "{id}/supprimer")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id){
        utilisateursServices.deleteUser(id);
    }
}