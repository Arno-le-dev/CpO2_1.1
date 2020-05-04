package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.example.cpo2_10.MainActivity.maBase;

public class top_5 extends AppCompatActivity {

    String name1;
    String marque1;
    String origine1;
    String empreinteCarbone1;
    String note1;

    String name2;
    String marque2;
    String origine2;
    String empreinteCarbone2;
    String note2;

    String name3;
    String marque3;
    String origine3;
    String empreinteCarbone3;
    String note3;

    String name4;
    String marque4;
    String origine4;
    String empreinteCarbone4;
    String note4;

    String name5;
    String marque5;
    String origine5;
    String empreinteCarbone5;
    String note5;

    private ImageButton home_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cette directive enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
// Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_top_10);

        Cursor c;
        c = maBase.rawQuery("SELECT * FROM fiche order By Note desc limit 5 ;", null);
        c.moveToFirst();

            // récupération des infos du produit + création objet de type fiche produit
            Button nom1 = (Button) findViewById(R.id.nom1);
            Button nom2 = (Button) findViewById(R.id.nom2);
            Button nom3 = (Button) findViewById(R.id.nom3);
            Button nom4 = (Button) findViewById(R.id.nom4);
            Button nom5 = (Button) findViewById(R.id.nom5);

            ImageView im1 = (ImageView) findViewById(R.id.im1);
            ImageView im2 = (ImageView) findViewById(R.id.im2);
            ImageView im3 = (ImageView) findViewById(R.id.im3);
            ImageView im4 = (ImageView) findViewById(R.id.im4);
            ImageView im5 = (ImageView) findViewById(R.id.im5);


            for (int i = 0; i < 5; i++) {
               if (i==0) {
                  nom1.setText(c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1));
                   if(c.getString(1).equals("Casino")){
                       im1.setImageResource(R.drawable.casino_logo);
                   }else if(c.getString(1).equals("Lidl")){
                       im1.setImageResource(R.drawable.lidl_logo);
                   }else{
                       im1.setImageResource(R.drawable.inter_logo);}
                    name1 = c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1);
                    marque1 = c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1);
                    origine1 = c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1);
                    empreinteCarbone1 = c.getString(3);
                    note1 = c.getString(4)+ "/5";


               }else {
                   c.moveToNext();
                   if (i == 1) {
                       nom2.setText(c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1));
                       if(c.getString(1).equals("Casino")){
                           im2.setImageResource(R.drawable.casino_logo);
                       }else if(c.getString(1).equals("Lidl")){
                           im2.setImageResource(R.drawable.lidl_logo);
                       }else{
                           im2.setImageResource(R.drawable.inter_logo);
                       }
                       name2 = c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1);
                       marque2 = c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1);
                       origine2 = c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1);
                       empreinteCarbone2 = c.getString(3);
                       note2 = c.getString(4)+ "/5";

                   }else if (i == 2) {
                       nom3.setText(c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1));
                       if(c.getString(1).equals("Casino")){
                           im3.setImageResource(R.drawable.casino_logo);
                       }else if(c.getString(1).equals("Lidl")){
                           im3.setImageResource(R.drawable.lidl_logo);
                       }else{
                           im3.setImageResource(R.drawable.inter_logo);
                       }
                       name3 = c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1);
                       marque3 = c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1);
                       origine3 = c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1);
                       empreinteCarbone3 = c.getString(3);
                       note3 = c.getString(4)+ "/5";
                   } else if (i == 3) {
                       nom4.setText(c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1));
                       if(c.getString(1).equals("Casino")){
                           im4.setImageResource(R.drawable.casino_logo);
                       }else if(c.getString(1).equals("Lidl")){
                           im4.setImageResource(R.drawable.lidl_logo);
                       }else{
                           im4.setImageResource(R.drawable.inter_logo);
                       }
                       name4 = c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1);
                       marque4 = c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1);
                       origine4 = c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1);
                       empreinteCarbone4 = c.getString(3);
                       note4 = c.getString(4)+ "/5";
                   } else{
                       nom5.setText(c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1));
                       if(c.getString(1).equals("Casino")){
                           im5.setImageResource(R.drawable.casino_logo);
                       }else if(c.getString(1).equals("Lidl")){
                           im5.setImageResource(R.drawable.lidl_logo);
                       }else{
                           im5.setImageResource(R.drawable.inter_logo);
                       }
                       name5 = c.getString(0).substring(0, 1).toUpperCase() + c.getString(0).substring(1);
                       marque5 = c.getString(1).substring(0,1).toUpperCase() + c.getString(1).substring(1);
                       origine5 = c.getString(2).substring(0,1).toUpperCase() + c.getString(2).substring(1);
                       empreinteCarbone5 = c.getString(3);
                       note5 = c.getString(4)+ "/5";
                   }
               }
            }
        c.close();

      final  Intent top = new Intent(getApplicationContext(), affichageTop.class);


      nom1.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View view) {
                    top.putExtra("name", name1);
                    top.putExtra("marque", marque1);
                    top.putExtra("origine", origine1);
                    top.putExtra("empreinteCarbone", empreinteCarbone1);
                    top.putExtra("note", note1);
                    startActivity(top);
                }
            });

        nom2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                top.putExtra("name", name2);
                top.putExtra("marque", marque2);
                top.putExtra("origine", origine2);
                top.putExtra("empreinteCarbone", empreinteCarbone2);
                top.putExtra("note", note2);
                startActivity(top);
                finish();
            }
        });
        nom3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                top.putExtra("name", name3);
                top.putExtra("marque", marque3);
                top.putExtra("origine", origine3);
                top.putExtra("empreinteCarbone", empreinteCarbone3);
                top.putExtra("note", note3);
                startActivity(top);
                finish();
            }
        });
        nom4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                top.putExtra("name", name4);
                top.putExtra("marque", marque4);
                top.putExtra("origine", origine4);
                top.putExtra("empreinteCarbone", empreinteCarbone4);
                top.putExtra("note", note4);
                startActivity(top);
                finish();
            }
        });
        nom5.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                top.putExtra("name", name5);
                top.putExtra("marque", marque5);
                top.putExtra("origine", origine5);
                top.putExtra("empreinteCarbone", empreinteCarbone5);
                top.putExtra("note", note5);
                startActivity(top);
                finish();
            }
        });

        // bouton home
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                // démarre nouvelle activité lorsque le bouton home est cliqué
                Intent result = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(result);
                finish();
            }
        });

    }
}

