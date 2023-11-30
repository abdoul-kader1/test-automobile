package com.lilcodeur.automobile.DTO;

import com.lilcodeur.automobile.modeles.Livraisons;

public record CommandesDto(
        int id,String date,String mode_paiement, String lieu
) {
}
