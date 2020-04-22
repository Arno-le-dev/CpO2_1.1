package com.example.cpo2_10.vue;

import androidx.appcompat.app.AppCompatActivity;



import android.database.Cursor;
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



import com.example.cpo2_10.Dialog_main;
import com.example.cpo2_10.R;
import com.example.cpo2_10.charte_activity;
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
        getSupportActionBar().hide();


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
                Intent addProduct = new Intent(getApplicationContext(), charte_activity.class);
                startActivity(addProduct);

            }
        });


        searchBtn = (Button) findViewById(R.id.searchBtn);
        nameSearch = (EditText) findViewById(R.id.Name);
        final String[] nom = new String[1];



        searchBtn.setOnClickListener(new Button.OnClickListener() {
                                         public void onClick(View view) {
                                             String nameS = nameSearch.getText().toString().toLowerCase();

                                             Cursor c;
                                             c = maBase.rawQuery("SELECT * FROM fiche WHERE Produit =? order By Note desc limit 1 ;", new String[]{nameS});

                                             if ((c != null ) && (c.moveToFirst())){
                                                 // démarre nouvelle activité lorsque le bouton ajouté est cliqué
                                                 Intent result = new Intent(getApplicationContext() , resultat.class);
                                                 // on fait passé la recherche dans l'autre activité
                                                 result.putExtra("nameSearch", nameS);
                                                 Log.d("test main Activity", "**********************" +nameS);
                                                 startActivity(result);
                                                 finish();
                                             }else {
                                                 openDialog();
                                             }
                                             }





    });


    }



    public void casinoWebsite(View view) {
        Intent casinoWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casinodrive.fr/ecommerce/prehome/drive?gclid=CjwKCAjwp-X0BRAFEiwAheRuixQjR5cwuVofaJ6VF0pPMtXpKhElHcRuMxT4RV6RVyv0uiApY1X5ihoC1sgQAvD_BwE"));
        startActivity(casinoWebsiteIntent);
    }

    public void lidl(View view) {
        Intent lidlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lidl.fr/"));
        startActivity(lidlIntent);
    }

    public void interWebsite(View view) {
        Intent interWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.intermarche.com/"));
        startActivity(interWebsiteIntent);
    }



public void openDialog(){
        Dialog_main dialog_main = new Dialog_main();
        dialog_main.show(getSupportFragmentManager(),"test");
}

}



