package com.example.cpo2_10.controleur;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.example.cpo2_10.R;
import com.example.cpo2_10.modele.AccesDistant;
import com.example.cpo2_10.modele.AccesLocal;
import com.example.cpo2_10.modele.add_newProduct;

import org.json.JSONArray;

import java.util.Date;

public final class Controle {


    private static Controle instance = null;
    private static AccesLocal accesLocal;


    /**
     * constructeur private
     */
    private Controle() {
        super();
    }


    public static final Controle getInstance(Context contexte) {
        if (Controle.instance == null) {
            Controle.instance = new Controle();
          //  accesLocal = new AccesLocal();
           // accesDistant.envoi("dernier", new JSONArray());
        }
        return Controle.instance;
    }

    /**
     * Création fiche produit
     * @param nomProduit
     * @param marqueProduit
     * @param empreinteCarbone en kg
     * @param origine
     */



    public void createProduct(String nomProduit, String marqueProduit, Integer empreinteCarbone , String origine){
        add_newProduct Product1 = new add_newProduct();
        Product1.Product(new Date(), nomProduit, marqueProduit, empreinteCarbone, origine);
        accesLocal.ajoutFiche(nomProduit, marqueProduit, empreinteCarbone, origine);


    }



}

