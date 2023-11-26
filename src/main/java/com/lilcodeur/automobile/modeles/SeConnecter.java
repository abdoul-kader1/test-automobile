package com.lilcodeur.automobile.modeles;

public class SeConnecter {
    private String email;
    private String mdp;

    public SeConnecter() {}

    public SeConnecter(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
