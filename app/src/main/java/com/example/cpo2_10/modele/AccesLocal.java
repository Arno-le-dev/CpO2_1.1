package com.example.cpo2_10.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cpo2_10.outils.MySQLiteOpenHelper;

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


        /**
         * ajout d'une fiche dans la DB
         * @param Product
         */

  /*      public void ajoutFiche (add_newProduct Product){
            bd = accesDB.getWritableDatabase();
            String req = "insert into fiche(dateMesure , Produit, Marque, Origine, EmpreinteCarbone) values";
            req += "(\"" + Product.getDateMesure() + "\"," + Product.getNomProduit() + "," + Product.getMarqueProduit() + "," + Product.getOrigine() + "," + Product.getEmpreinteCarbone() + ")";
            bd.execSQL(req);


        }*/
    }

}


