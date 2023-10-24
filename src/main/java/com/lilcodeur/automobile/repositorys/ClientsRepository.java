package com.lilcodeur.automobile.repositorys;

import com.lilcodeur.automobile.modeles.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients,Integer>{
    //recuperer un client en fonction de son email
    Clients findByEmail(String email);
}
