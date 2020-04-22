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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cpo2_10.Dialog_main;
import com.example.cpo2_10.R;
import com.example.cpo2_10.dialog_ajout;
import com.example.cpo2_10.resultat;
import com.example.cpo2_10.vue.MainActivity;

import java.util.Date;
import java.util.Dictionary;

public class add_newProduct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //elements d'affichage
    private EditText txtProduit;
    private EditText txtEmpreinteCarbon;
    private Button buttonadd;
    private ImageButton home_button;


    public static int i;

    private int note;

    AlertDialog.Builder builder;


    static SQLiteDatabase maBase = MainActivity.maBase;

    // tableau de pays
    public static String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria",
            "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
            "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
            "Brazil", "British Indian Ocean Territory", "British Virgin Islands", "Brunei", "Bulgaria",
            "Burkina Faso", "Burma (Myanmar)", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
            "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island",
            "Cocos (Keeling) Islands", "Colombia", "Comoros", "Cook Islands", "Costa Rica",
            "Croatia", "Cuba", "Cyprus", "Czech Republic", "Democratic Republic of the Congo",
            "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
            "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "French Polynesia",
            "Gabon", "Gambia", "Gaza Strip", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece",
            "Greenland", "Grenada", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
            "Haiti", "Holy See (Vatican City)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Ivory Coast", "Jamaica",
            "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait",
            "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein",
            "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia",
            "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mayotte", "Mexico",
            "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco",
            "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia",
            "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea",
            "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama",
            "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn Islands", "Poland",
            "Portugal", "Puerto Rico", "Qatar", "Republic of the Congo", "Romania", "Russia", "Rwanda",
            "Saint Barthelemy", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin",
            "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone",
            "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea",
            "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland",
            "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tokelau",
            "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands",
            "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "US Virgin Islands", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam",
            "Wallis and Futuna", "West Bank", "Yemen", "Zambia", "Zimbabwe", "Angleterre", "USA"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Cette directive enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
// Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_add_new_product);


// mise en place spinner magasin :
        final Spinner magasinSpin = findViewById(R.id.magasinSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.magasin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        magasinSpin.setAdapter(adapter);

        magasinSpin.setOnItemSelectedListener(this);


        txtProduit = (EditText) findViewById(R.id.txtProduit);
        txtEmpreinteCarbon = (EditText) findViewById(R.id.txtEmpreinteCarbone);
        buttonadd = (Button) findViewById(R.id.btnAdd);


        // mise en place autoComplete view pour l'origine
        final AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        editText.setAdapter(adapt);

        i = 0;

        // definition des actions quand je clique sur boutonadd
        buttonadd.setOnClickListener(new Button.OnClickListener() {
                                         public void onClick(View v) {


                                             String Produit = (txtProduit.getText().toString().toLowerCase());
                                             String Origine = (editText.getText().toString());
                                             float empreinteCarbone = 0;

                                             String Marque = magasinSpin.getSelectedItem().toString();
                                             // récupération des données saisies
                                             try {
                                                 empreinteCarbone = Float.parseFloat(txtEmpreinteCarbon.getText().toString());

                                             } catch (Exception e) {
                                             }

                                             // Contrôle 1 valeur empreinte Carbone dans le log
                                             Log.d("empreinte Carbone", "La E.C est de:" + empreinteCarbone);

                                             if (empreinteCarbone == 0.0) {
                                                 Toast.makeText(add_newProduct.this, "Saisie de l'empreinte carbone incorrecte", Toast.LENGTH_SHORT).show();

                                             }else{

                                                 if(i==1){
                                                     note = calculerNote(empreinteCarbone);
                                                     // contrôle de la valeur de note dans le log
                                                     Log.d("Note", "La note est de:" + note);

                                                     creationFiche(Produit, Marque, empreinteCarbone, Origine, note);

                                                     Toast.makeText(add_newProduct.this, "Produit ajouté, merci beaucoup !", Toast.LENGTH_SHORT).show();
                                                     Intent result = new Intent(getApplicationContext(), MainActivity.class);
                                                     startActivity(result);
                                                     finish();
                                                 }else{

                                                         dialog_ajout dialog_main = new dialog_ajout();
                                                         dialog_main.show(getSupportFragmentManager(),"appel à la relecture");
                                                     }
                                                 }







                                             }

                                         }

        );


        home_button = (ImageButton) findViewById(R.id.home_button);
        home_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                // démarre nouvelle activité lorsque le bouton ajouté est cliqué
                Intent result = new Intent(getApplicationContext(), MainActivity.class);
                // on fait passé la recherche dans l'autre activité
                startActivity(result);
                finish();
            }

        });


    }

    /**
     * Ajout fiche dans la base de donnée
     *
     * @param Produit
     * @param Marque
     * @param EmpreinteCarbone
     * @param Origine
     * @param note
     */
    public void creationFiche(String Produit, String Marque, float EmpreinteCarbone, String Origine, int note) {
        String req = "insert into fiche(Produit, Marque, Origine, EmpreinteCarbone, note) values";
        req += "(\"" + Produit + "\", \"" + Marque + "\", \"" + Origine + "\", " + EmpreinteCarbone + "," + note + " )";
        maBase.execSQL(req);

        // juste du code de visualisation
        try {
            // on execute la requete SQL et on récupère les résultats dans un Cursor c
            Cursor c = maBase.rawQuery("Select Produit from fiche order by Produit asc;", null);
            // on ajoute chaque ligne du cursor dans le tableau results
            while (c.moveToNext()) {
                String a = c.getString(c.getColumnIndex("Produit"));
                System.out.println("produit : " + a);
            }
        } catch (SQLiteException se) {
            Log.e("rawQuery", "Probleme SQL");
        }

    }


    /**
     * Calcul de la note du produit
     */

    private int calculerNote(float e) {

        if (e <= 1.0) {

            return (5);
        } else if (e > 1.0 && e <= 3.0) {

            return (4);
        } else if (e > 3.0 && e <= 6.0) {

            return (3);
        } else if (e > 6.0 && e <= 9.0) {

            return (2);
        } else if (e > 9.0 && e <= 11.0) {

            return (1);
        } else
            note = 0;
        return (0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



