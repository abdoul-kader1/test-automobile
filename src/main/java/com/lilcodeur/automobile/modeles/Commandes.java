package com.lilcodeur.automobile.modeles;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "commandes")
@Data
public class Commandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date,mode_paiement;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "id_utilisateur")
    private Utilisateurs utilisateurs;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "id_produit")
    private Produits produits;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "id_livraison")
    private Livraisons livraisons;
}
