package com.example.cpo2_10;


import java.util.Date;

public class FicheProduit {

    /**
     * Propriétés du produit
     */

    private String nomProduit;
    private String marqueProduit;
    private float empreinteCarbone;
    private String origine;
    private int note;


    public String getNomProduit() {
        return nomProduit;
    }
    public String getMarqueProduit() {
        return marqueProduit;
    }

    public float getEmpreinteCarbone() {
        return empreinteCarbone;
    }
    public String getOrigine() {
        return origine;
    }

    public int getNote() {
        return note;
    }


    public FicheProduit(String nomProduit, String marqueProduit, float empreinteCarbone, String origine, int note) {
        this.nomProduit = nomProduit;
        this.marqueProduit = marqueProduit;
        this.empreinteCarbone = empreinteCarbone;
        this.origine = origine;
        this.note = note;



    }
}