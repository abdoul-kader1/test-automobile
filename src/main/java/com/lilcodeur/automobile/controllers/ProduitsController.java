package com.lilcodeur.automobile.controllers;

import com.lilcodeur.automobile.modeles.Produits;
import com.lilcodeur.automobile.services.ProduitsServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produits")
@AllArgsConstructor
public class ProduitsController {
    private ProduitsServices produitsServices;
    @PostMapping("add")
    public void add(@RequestBody Produits produits){
        produitsServices.add(produits);
    }
}
