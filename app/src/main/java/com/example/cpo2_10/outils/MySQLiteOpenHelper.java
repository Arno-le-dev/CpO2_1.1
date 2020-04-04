package com.example.cpo2_10.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    //propiétés
    private String creation ="create table fiche ("
            + "dateMesure TEXT PRIMARY KEY,"
            + "Produit TEXT PRIMARY KEY,"
            + "Marque TEXT PRIMARY KEY,"
            + "Origine TEXT PRIMARY KEY,"
            + "EmpreinteCarbone INTEGER NOT NULL);";


    /**
     * Constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Si changement de DB (dataBase)
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(creation);
    }

    /**
     * Si changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
