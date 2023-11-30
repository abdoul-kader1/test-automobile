package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.modeles.Utilisateurs;
import com.lilcodeur.automobile.repositorys.UtilisateursRepositorie;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UtilisateursServices {
    private final UtilisateursRepositorie utilisateursRepositorie;
    //Ajouter un utilisateur dans la BDD
    public void add(Utilisateurs utilisateurs){
        Utilisateurs userBd = utilisateursRepositorie.findByEmail(utilisateurs.getEmail());
        if(userBd==null){
            this.utilisateursRepositorie.save(utilisateurs);
        }else{
            throw new EntityNotFoundException("l'email est utilisé par un autre utilisateur");
        }
    }
    //retourne un Utilisateur en fonction de son id
    public Utilisateurs obtenirUtilisateur(int id){
        Utilisateurs userBdd = utilisateursRepositorie.findById(id);
        if(userBdd == null){
            throw new EntityNotFoundException("id user invalide");
        }else{
            return userBdd;
        }
    }
    //retourne la liste des utilisateurs
    public List<Utilisateurs> listeUtilisateur(){
        return utilisateursRepositorie.findAll();
    }
    //mettre a jour les informations de l'utilisateurs
    public void miseAjourInfoUtilisateur(int id,Utilisateurs utilisateurs){
        Utilisateurs userBd = obtenirUtilisateur(id);
        if(Objects.equals(userBd.getId(), utilisateurs.getId())){
            userBd.setEmail(utilisateurs.getEmail());
            userBd.setMdp(utilisateurs.getMdp());
            utilisateursRepositorie.save(userBd);
        }else{
            throw new EntityNotFoundException("id utilisateur incorrect");
        }
    }
    //supprimer un utilisateur dans la bdd
    public void deleteUser(int id){
        utilisateursRepositorie.deleteById(id);
    }

}
