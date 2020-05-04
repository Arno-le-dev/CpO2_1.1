package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.cpo2_10.MainActivity.maBase;


public class resultat extends AppCompatActivity {


    private ImageButton home_button;
    private ImageButton magBtn;
    String Marque;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Cette directive enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


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

                Log.d("test empreinte carbone", "***********EmpreinteCarbonne= " + c.getFloat(3));

                TextView nom = (TextView) findViewById(R.id.nom);
                TextView marque = (TextView) findViewById(R.id.marque);
                TextView origine = (TextView) findViewById(R.id.origine);
                TextView empreinteC = (TextView) findViewById(R.id.empreinteCarbone);
                TextView note = (TextView) findViewById(R.id.note);


                nom.setText(c.getString(0).substring(0,1).toUpperCase() + c.getString(0).substring(1));
                marque.setText(c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1));
                origine.setText(c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1));
                empreinteC.setText(c.getString(3));
                note.setText(c.getString(4)+ "/5");

                Marque = c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1);


            }
            c.close();
        } catch (SQLException se) {
            Log.e("rawQuery", "erreur requette**********");
        }



        // bouton home
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                // démarre nouvelle activité lorsque le bouton home est cliqué
                Intent result = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(result);
                finish();
            }

        });


        magBtn = (ImageButton) findViewById(R.id.magBtn);

        // correspondance imagebutton avec marque de la recherche
        if(Marque.equals("Casino")){
           magBtn.setImageResource(R.drawable.casino_logo);
        }else if(Marque.equals("Lidl")){
            magBtn.setImageResource(R.drawable.lidl_logo);
        }else{
            magBtn.setImageResource(R.drawable.inter_logo);
        }


        // correspondance button magasin avec marque de la recherche
        magBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                if(Marque.equals("Casino")){
                    Intent casinoWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casinodrive.fr/ecommerce/prehome/drive?gclid=CjwKCAjwp-X0BRAFEiwAheRuixQjR5cwuVofaJ6VF0pPMtXpKhElHcRuMxT4RV6RVyv0uiApY1X5ihoC1sgQAvD_BwE"));
                    startActivity(casinoWebsiteIntent);
                }else if(Marque.equals("Lidl")){
                    Intent lidlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lidl.fr/"));
                    startActivity(lidlIntent);
                }else{
                    Intent interWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.intermarche.com/"));
                    startActivity(interWebsiteIntent);
                }
            }


        });

    }

}

