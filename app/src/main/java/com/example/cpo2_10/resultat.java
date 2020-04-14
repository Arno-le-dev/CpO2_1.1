package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static com.example.cpo2_10.vue.MainActivity.maBase;


public class resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        try {
            // on récupère la recherche venant de main_activity
            Intent result = getIntent();

            String nameS = "";

        // methode if pour éviter les crashs
            if(result != null){

                if (result.hasExtra("nameSearch")){
                    nameS = result.getStringExtra("nameSearch");
                    Log.d("test valeur recherchée", nameS);
                }
            }
// déclaration du curseur et requête
            Cursor c;
            c = maBase.rawQuery("SELECT * FROM fiche WHERE Produit =? order By Note desc limit 1 ;", new String[]{nameS});
            while (c.moveToNext()) {
                // récupération des infos du produit + création objet de type fiche produit

                Log.d("test empreinte carbone", "EmpreinteCarbonne= " + c.getFloat(3));

                TextView nom = (TextView) findViewById(R.id.nom);
                TextView marque = (TextView) findViewById(R.id.marque);
                TextView origine = (TextView) findViewById(R.id.origine);
                TextView empreinteC = (TextView) findViewById(R.id.empreinteC);
                TextView note = (TextView) findViewById(R.id.note);


                nom.setText(c.getString(0).substring(0,1).toUpperCase() + c.getString(0).substring(1));
                marque.setText(c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1));
                origine.setText(c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1));
                empreinteC.setText(c.getString(3));
                note.setText(c.getString(4)+ "/5");



            }
            c.close();
        } catch (SQLException se) {
            Log.e("rawQuery", "erreur requette**********");
        }





    }

}

