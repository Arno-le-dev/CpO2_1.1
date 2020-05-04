package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class affichageTop extends AppCompatActivity {


    private ImageButton home_button;
    ImageButton magBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Cette directive enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_top1);

        try {
            // on récupère la recherche venant de main_activity
            Intent top = getIntent();

            String nom = "";
            String marque = "";
            String origine = "";
            String empreinteCarbone = "";
            String note = "";

            // methode if pour éviter les crashs
            if (top != null) {

                if (top.hasExtra("name")) {
                    nom = top.getStringExtra("name");
                }
                if (top.hasExtra("marque")) {
                    marque = top.getStringExtra("marque");
                }else{
                }

                if (top.hasExtra("origine")) {
                    origine = top.getStringExtra("origine");
                }
                if (top.hasExtra("empreinteCarbone")) {
                    empreinteCarbone = top.getStringExtra("empreinteCarbone");
                }
                if (top.hasExtra("note")) {
                    note = top.getStringExtra("note");
                }
            }
            Log.d("test ", "test" +marque);

            TextView nom1 = (TextView) findViewById(R.id.nom);
            TextView marque1 = (TextView) findViewById(R.id.marque);
            TextView origine1 = (TextView) findViewById(R.id.origine);
            TextView empreinteC1 = (TextView) findViewById(R.id.empreinteCarbone);
            TextView note1 = (TextView) findViewById(R.id.note);

            nom1.setText(nom);
            marque1.setText(marque);
            origine1.setText(origine);
            empreinteC1.setText(empreinteCarbone);
            note1.setText(note);

            magBtn = (ImageButton) findViewById(R.id.magBtn);

            // correspondance imagebutton avec marque de la recherche
            if (marque.equals("Casino")) {
                magBtn.setImageResource(R.drawable.casino_logo);
                magBtn.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent casinoWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casinodrive.fr/ecommerce/prehome/drive?gclid=CjwKCAjwp-X0BRAFEiwAheRuixQjR5cwuVofaJ6VF0pPMtXpKhElHcRuMxT4RV6RVyv0uiApY1X5ihoC1sgQAvD_BwE"));
                        startActivity(casinoWebsiteIntent);
                    }
                });

            } else if (marque.equals("Lidl")) {
                magBtn.setImageResource(R.drawable.lidl_logo);
                magBtn.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent lidlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lidl.fr/"));
                        startActivity(lidlIntent);
                    }
                });
            } else {
                magBtn.setImageResource(R.drawable.inter_logo);
                magBtn.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {

                        Intent interWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.intermarche.com/"));
                        startActivity(interWebsiteIntent);
                    }
                });
            }

        } catch (
                SQLException se) {
            Log.e("rawQuery", "erreur requette**********");
        }

        // bouton home
        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                // démarre nouvelle activité lorsque le bouton home est cliqué
                Intent result = new Intent(getApplicationContext(), top_5.class);
                startActivity(result);
                finish();
            }
        });
    }
}
