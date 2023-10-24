package com.lilcodeur.automobile.modeles;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "voitures")
public class Voitures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String marque,modele,couleur;
    @ManyToOne(cascade = {PERSIST,MERGE})
    @JoinColumn(name = "client")
    Clients client;

    public Voitures() {}

    public Voitures(int id, String marque, String modele, String couleur, Clients client) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
