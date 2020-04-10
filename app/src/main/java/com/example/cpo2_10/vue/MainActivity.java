package com.example.cpo2_10.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpo2_10.R;
import com.example.cpo2_10.controleur.Controle;
import com.example.cpo2_10.modele.add_newProduct;


public class MainActivity extends AppCompatActivity {

    private ImageView add;

    public static SQLiteDatabase maBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maBase = openOrCreateDatabase("maBaseDeDonneesProduits",MODE_PRIVATE,null);
        // on cree la table pokemon si elle n'existait pas

        String creation ="create table if not exists fiche ("
                + "Produit TEXT ,"
                + "Marque TEXT ,"
                + "Origine TEXT ,"
                + "EmpreinteCarbone REAL NOT NULL,"
                + "Note REAL NOT NULL"
                + ")";
        maBase.execSQL(creation);



        this.add= (ImageView) findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduct = new Intent(getApplicationContext() , add_newProduct.class);
                startActivity(addProduct);

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

