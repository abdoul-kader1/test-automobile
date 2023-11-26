package com.lilcodeur.automobile.services;

import com.lilcodeur.automobile.modeles.Clients;
import com.lilcodeur.automobile.modeles.NomPrenom;
import com.lilcodeur.automobile.modeles.SeConnecter;
import com.lilcodeur.automobile.repositorys.ClientsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientsServices {
    private final ClientsRepository clientsRepository;

    public ClientsServices(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public Clients seConnecter(SeConnecter connecter){
        Clients clientsBd = this.clientsRepository.findByEmail(connecter.getEmail());
        if(clientsBd!=null){
            if(Objects.equals(connecter.getMdp(), clientsBd.getMdp())){
                return clientsBd;
            }else{
                throw new EntityNotFoundException("le mot de passe est incorrecte");
            }
        }else{
            throw new EntityNotFoundException("l'adresse email est incorrecte");
        }
    }

    public void ajouterClients(Clients clients){
        Clients clientBd = this.clientsRepository.findByEmail(clients.getEmail());
        if(clientBd == null){
            this.clientsRepository.save(clients);
        }else{
            throw new EntityNotFoundException("l'email existe deja");
        }
    }
    public List<Clients> recupListClients(){
        return this.clientsRepository.findAll();
    }
    public Clients unClient(int id){
        Optional<Clients>optionalClients = this.clientsRepository.findById(id);
        return optionalClients.orElseThrow(
                ()-> new EntityNotFoundException("ce client n'existe pas")
        );
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
    public void testClient(Clients clients){
        Clients clientBd = this.clientsRepository.findByEmail(clients.getEmail());
        if(clientBd==null){
            this.clientsRepository.createClient(clients.getNom(),clients.getPrenom(),clients.getEmail(),clients.getMdp());
        }
    }
    //recuperer le nom et le prenom d'un utilisateur
    public List<NomPrenom> getNomPrenomClients(){
        return this.clientsRepository.findNomAndPrenom();
    }
}
