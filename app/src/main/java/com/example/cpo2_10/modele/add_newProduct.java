package com.example.cpo2_10.modele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cpo2_10.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class add_newProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
    }

    /**
     * Propriétés du produit
     */
    private Date dateMesure;
    private String nomProduit;
    private String marqueProduit;
    private Integer empreinteCarbone;
    private String origine;
    private Integer note;


    public void Product(Date dateMesure, String nomProduit, String marqueProduit, Integer empreinteCarbone, String origine) {
        this.dateMesure = dateMesure;
        this.nomProduit = nomProduit;
        this.marqueProduit = marqueProduit;
        this.empreinteCarbone = empreinteCarbone;
        this.origine = origine;
        this.calculerNote();
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

    public Date getDateMesure() { return dateMesure; }


    /**
     * Calcul de la note du produit
     */
    private void calculerNote() {

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




