package com.example.cpo2_10.modele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cpo2_10.R;

public class add_newProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
    }

// Propriétés produit

    private String nomProduit;
    private String marqueProduit;
    private Integer empreinteCarbone;
    private String origine;
    private Integer note;

    public add_newProduct(String nomProduit, String marqueProduit, Integer empreinteCarbone, String origine) {
        this.nomProduit = nomProduit;
        this.marqueProduit = marqueProduit;
        this.empreinteCarbone = empreinteCarbone;
        this.origine = origine;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getMarqueProduit() {
        return marqueProduit;
    }

    public Integer getEmpreinteCarbone() {
        return empreinteCarbone;
    }

    public String getOrigine() {
        return origine;
    }

    public Integer getNote() {
        return note;
    }

    private void caculerNote() {

        if (empreinteCarbone <= 1)
            note = 5;

        else if (empreinteCarbone >= 1 && empreinteCarbone <= 3)
            note = 4;

        else if (empreinteCarbone > 3 && empreinteCarbone <= 6)
            note = 3;

        else if (empreinteCarbone > 6 && empreinteCarbone <= 9)
            note = 2;

        else if (empreinteCarbone > 9 && empreinteCarbone <= 11)
            note = 1;

        else
            note = 0;
        }

    }

