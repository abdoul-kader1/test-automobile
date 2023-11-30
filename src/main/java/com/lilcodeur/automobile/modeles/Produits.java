package com.lilcodeur.automobile.modeles;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produits")
@Data
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom,couleur,prix;
}
