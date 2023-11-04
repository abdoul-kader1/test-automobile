package com.lilcodeur.automobile.modeles;

public class VoituresNative {
    private String marque,modele,couleur;
    private int idClients;

    public VoituresNative(String marque, String modele, String couleur, int idClients) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.idClients = idClients;
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

    public int getIdClients() {
        return idClients;
    }

    public void setIdClients(int idClients) {
        this.idClients = idClients;
    }
}
