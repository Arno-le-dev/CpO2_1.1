    package com.example.cpo2_10.modele;

    import androidx.appcompat.app.AppCompatActivity;

    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteException;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.example.cpo2_10.R;
    import com.example.cpo2_10.controleur.Controle;
    import com.example.cpo2_10.vue.MainActivity;

    import org.json.JSONArray;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class add_newProduct extends AppCompatActivity {

        //elements d'affichage
        private EditText txtProduit;
        private EditText txtMarque;
        private EditText txtOrigine;
        private EditText txtEmpreinteCarbon;
        private Button buttonadd;

        /**
         * Propriétés du produit
         */
        private Date dateMesure;
        private String nomProduit;
        private String marqueProduit;
        private float empreinteCarbone;
        private String origine;
        private int note;


        static SQLiteDatabase maBase = MainActivity.maBase;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_new_product);

            txtProduit = (EditText) findViewById(R.id.txtProduit);
            txtMarque = (EditText) findViewById(R.id.txtMarque);
            txtOrigine = (EditText) findViewById(R.id.txtOrigine);
            txtEmpreinteCarbon = (EditText) findViewById(R.id.txtEmpreinteCarbone);
            buttonadd = (Button) findViewById(R.id.btnAdd);

            // definition des actions quand je clique sur boutonadd
            buttonadd.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View v) {

                                                 String Produit = (txtProduit.getText().toString());
                                                 String Marque = (txtMarque.getText().toString());
                                                 String Origine = (txtOrigine.getText().toString());
                                                 float empreinteCarbone = 0;
                                                 // récupération des données saisies
                                                 try {
                                                     empreinteCarbone = Float.parseFloat(txtEmpreinteCarbon.getText().toString());

                                                 } catch (Exception e) {
                                                 }
                                                 ;
                                                 // contrôle conformité valeur saisie
                                                 if (empreinteCarbone == 0) {
                                                     Toast.makeText(add_newProduct.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                                                 } else {
                                                     // tout est OK
                                                     Toast.makeText(add_newProduct.this, "OK pour l'ajout", Toast.LENGTH_SHORT).show();
                                                     calculerNote();
                                                     creationFiche(Produit, Marque, empreinteCarbone, Origine, note);
                                                 }

                                             }
                                         }
            );

        }


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


        public String getNomProduit() {
            return nomProduit;
        }

        public String getMarqueProduit() {
            return marqueProduit;
        }

        public float getEmpreinteCarbone() {
            return empreinteCarbone;
        }

        public String getOrigine() {
            return origine;
        }

        public int getNote() {
            return note;
        }

        public Date getDateMesure() { return dateMesure; }


        /**
         * Calcul de la note du produit
         */
        private void calculerNote() {

            if (empreinteCarbone <= 1)
                note = 5;

            else if (empreinteCarbone >= 1 && empreinteCarbone <= 3)
                note = 4;

            else if (empreinteCarbone > 3 && empreinteCarbone <= 6)
                note = 3;

            else if (empreinteCarbone > 6 && empreinteCarbone <= 9)
                note = 2;

            else if (empreinteCarbone > 9 && empreinteCarbone <= 11)
                note = 1;

            else
                note = 0;
            }
    }




