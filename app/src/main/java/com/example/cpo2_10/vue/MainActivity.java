package com.example.cpo2_10.vue;

import androidx.appcompat.app.AppCompatActivity;



import android.database.sqlite.SQLiteDatabase;


import android.net.Uri;

import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.cpo2_10.FicheProduit;
import com.example.cpo2_10.R;
import com.example.cpo2_10.modele.add_newProduct;
import com.example.cpo2_10.resultat;

public class MainActivity extends AppCompatActivity {

    private ImageView add;

    public static SQLiteDatabase maBase;
    private EditText nameSearch;
    private Button searchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cette directive enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
// Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        maBase = openOrCreateDatabase("maBaseDeDonneesProduits", MODE_PRIVATE, null);
        // on cree la table pokemon si elle n'existait pas

        String creation = "create table if not exists fiche ("
                + "Produit TEXT ,"
                + "Marque TEXT ,"
                + "Origine TEXT ,"
                + "EmpreinteCarbone FLOAT NOT NULL,"
                + "Note REAL NOT NULL"
                + ")";
        maBase.execSQL(creation);


        this.add = (ImageView) findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduct = new Intent(getApplicationContext(), add_newProduct.class);
                startActivity(addProduct);

            }
        });


        searchBtn = (Button) findViewById(R.id.searchBtn);
        nameSearch = (EditText) findViewById(R.id.Name);
        final String[] nom = new String[1];



        searchBtn.setOnClickListener(new Button.OnClickListener() {
                                         public void onClick(View view) {
                                             String nameS = nameSearch.getText().toString().toLowerCase();


                                             // démarre nouvelle activité lorsque le bouton ajouté est cliqué
                                             Intent result = new Intent(getApplicationContext() , resultat.class);
                                             // on fait passé la recherche dans l'autre activité
                                             result.putExtra("nameSearch", nameS);
                                             Log.d("test main Activity", "**********************" +nameS);
                                             startActivity(result);
                                             finish();
                                         }

    });


    }


    // hello
    public void carrefourWebsite(View view) {
        Intent carrefourWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.carrefour.fr/services/drive"));
        startActivity(carrefourWebsiteIntent);
    }

    public void casinoWebsite(View view) {
        Intent casinoWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casinodrive.fr/ecommerce/prehome/drive"));
        startActivity(casinoWebsiteIntent);
    }

    public void interWebsite(View view) {
        Intent interWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.intermarche.com/"));
        startActivity(interWebsiteIntent);
    }

    public void UWebsite(View view) {
        Intent UWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursesu.com/drive/home"));
        startActivity(UWebsiteIntent);


    }



}



