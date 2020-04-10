package com.example.cpo2_10.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cpo2_10.controleur.Controle;
import com.example.cpo2_10.outils.MySQLiteOpenHelper;

import java.util.Date;

public class AccesLocal {

    // propriétés
    private String nomBase = "DB.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesDB;
    private SQLiteDatabase bd;


    /**
     * Constructeur
     *
     * @param contexte
     */
    public AccesLocal(Context contexte) {
        accesDB = new MySQLiteOpenHelper(contexte, nomBase, null, versionBase);



    }

    /**
     * ajout d'une fiche dans la DB
     * @param
     */
        public void ajoutFiche (String nomProduit, String marqueProduit, Integer empreinteCarbone, String origine){
            add_newProduct Product2 = new add_newProduct();
            Product2.Product(new Date(), nomProduit, marqueProduit, empreinteCarbone, origine);
            bd = accesDB.getWritableDatabase();
            String req = "insert into fiche(dateMesure, Produit, Marque, Origine, EmpreinteCarbone) values";
            req += "(\"" + Product2.getDateMesure() + "\"," + Product2.getNomProduit() + "," + Product2.getMarqueProduit() + "," + Product2.getOrigine() + "," + Product2.getEmpreinteCarbone() + ")";
            bd.execSQL(req);
        }
    }



