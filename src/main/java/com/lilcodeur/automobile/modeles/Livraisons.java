package com.lilcodeur.automobile.modeles;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "livraisons")
@Data
public class Livraisons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lieu;

    //@OneToMany(mappedBy = "livraisons")
    //private List<Commandes>commandes;
}
