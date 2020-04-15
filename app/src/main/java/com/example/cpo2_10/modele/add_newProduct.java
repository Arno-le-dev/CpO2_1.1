    package com.example.cpo2_10.modele;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.DialogInterface;
    import android.content.Intent;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteException;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.view.Window;
    import android.view.WindowManager;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.ImageView;
    import android.widget.Toast;

    import com.example.cpo2_10.R;
    import com.example.cpo2_10.resultat;
    import com.example.cpo2_10.vue.MainActivity;

    import java.util.Date;
    import java.util.Dictionary;

    public class add_newProduct extends AppCompatActivity {

        //elements d'affichage
        private EditText txtProduit;
        private EditText txtMarque;
        private EditText txtOrigine;
        private EditText txtEmpreinteCarbon;
        private Button buttonadd;
        private ImageButton home_button;

        private int note;

AlertDialog verifOrtho;
AlertDialog.Builder builder;



        static SQLiteDatabase maBase = MainActivity.maBase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //Cette directive enlève la barre de titre
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
// Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();

            setContentView(R.layout.activity_add_new_product);




            txtProduit = (EditText) findViewById(R.id.txtProduit);
            txtMarque = (EditText) findViewById(R.id.txtMarque);
            txtOrigine = (EditText) findViewById(R.id.txtOrigine);
            txtEmpreinteCarbon = (EditText) findViewById(R.id.txtEmpreinteCarbone);
            buttonadd = (Button) findViewById(R.id.btnAdd);



            // definition des actions quand je clique sur boutonadd
            buttonadd.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View v) {

                                                 String Produit = (txtProduit.getText().toString().toLowerCase());
                                                 String Marque = (txtMarque.getText().toString());
                                                 String Origine = (txtOrigine.getText().toString());
                                                 float empreinteCarbone = 0;

                                                 // récupération des données saisies
                                                 try {
                                                     empreinteCarbone = Float.parseFloat(txtEmpreinteCarbon.getText().toString());

                                                 } catch (Exception e) {
                                                 }

                                                 // Contrôle 1 valeur empreinte Carbone dans le log
                                                 Log.d("empreinte Carbone", "La E.C est de:" + empreinteCarbone);

                                                 // contrôle 2 conformité valeur saisie
                                                 if (empreinteCarbone == 0.0) {
                                                     Toast.makeText(add_newProduct.this, "Saisie de l'empreinte carbone incorrecte", Toast.LENGTH_SHORT).show();
                                                 } else {
                                                     // tout est OK
                                                     note = calculerNote(empreinteCarbone);
                                                     // contrôle de la valeur de note dans le log
                                                     Log.d("Note", "La note est de:" + note);

                                                     creationFiche(Produit, Marque, empreinteCarbone, Origine, note);

                                                     Toast.makeText(add_newProduct.this, "Produit ajouté", Toast.LENGTH_SHORT).show();

                                                     builder = new AlertDialog.Builder(add_newProduct.this);
                                                     builder.setTitle("Avez vous vérifier l'orthographe?");

                                                     builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                                                         @Override
                                                         public void onClick(DialogInterface dialog, int which) {
                                                         }
                                                     });
                                                     builder.setNegativeButton("Je le fais maintenant", new DialogInterface.OnClickListener() {

                                                         @Override
                                                         public void onClick(DialogInterface dialog, int which) {

                                                         }
                                                     });


                                                 }




                                             }
                                         }
            );



           home_button = (ImageButton) findViewById(R.id.home_button);
            home_button.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View view) {

                    // démarre nouvelle activité lorsque le bouton ajouté est cliqué
                    Intent result = new Intent(getApplicationContext() , MainActivity.class);
                    // on fait passé la recherche dans l'autre activité
                    startActivity(result);
                    finish();
                }

            });


        }

        /**
         * Ajout fiche dans la base de donnée
         * @param Produit
         * @param Marque
         * @param EmpreinteCarbone
         * @param Origine
         * @param note
         */
            public void creationFiche(String Produit, String Marque, float EmpreinteCarbone, String Origine, int note ){
                String req = "insert into fiche(Produit, Marque, Origine, EmpreinteCarbone, note) values";
                req += "(\"" + Produit+ "\", \"" + Marque + "\", \"" + Origine + "\", "+ EmpreinteCarbone + "," +note + " )";
                maBase.execSQL(req);

                // juste du code de visualisation
                try {
                    // on execute la requete SQL et on récupère les résultats dans un Cursor c
                    Cursor c = maBase.rawQuery("Select Produit from fiche order by Produit asc;", null);
                    // on ajoute chaque ligne du cursor dans le tableau results
                    while (c.moveToNext()) {
                        String a = c.getString(c.getColumnIndex("Produit"));
                        System.out.println("produit : "+a);
                    }
                }
                catch (SQLiteException se ) {
                    Log.e("rawQuery", "Probleme SQL");
                }

            }




        /**
         * Calcul de la note du produit
         */

        private int calculerNote(float e) {

            if (e <= 1.0) {

            return(5);}

            else if (e > 1.0 && e <= 3.0){

            return(4);}

            else if (e > 3.0 && e <= 6.0){

            return(3);}

            else if (e > 6.0 && e <= 9.0){

            return(2);}

            else if (e > 9.0 && e <= 11.0){

            return(1);}

            else
                note = 0;
            return(0);
        }
    }



