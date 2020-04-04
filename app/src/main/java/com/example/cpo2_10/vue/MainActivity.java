package com.example.cpo2_10.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpo2_10.R;
import com.example.cpo2_10.controleur.Controle;
import com.example.cpo2_10.modele.add_newProduct;


public class MainActivity extends AppCompatActivity {

    private ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // doute
        init();
        this.controle= Controle.getInstance();


        this.add= (ImageView) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduct = new Intent(getApplicationContext() , add_newProduct.class);
                startActivity(addProduct);
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

    //propriétés
    private EditText txtProduit;
    private EditText txtMarque;
    private EditText txtOrigine;
    private EditText txtEmpreinteCarbon;
    private Button buttonadd;
    private TextView txtnote;
    private Controle controle;

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){
        txtProduit = (EditText) findViewById(R.id.txtProduit);
        txtMarque = (EditText) findViewById(R.id.txtMarque);
        txtOrigine = (EditText) findViewById(R.id.txtOrigine);
        txtEmpreinteCarbon = (EditText) findViewById(R.id.txtEmpreinteCarbone);
        buttonadd = (Button) findViewById(R.id.btnAdd);
        ecouteAddBtn();
    }

  private void ecouteAddBtn(){
        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){

                String Produit = (txtProduit.getText().toString());
                String Marque= (txtMarque.getText().toString());
                String Origine = (txtOrigine.getText().toString());

                Integer empreinteCarbone=0;
               // récupération des données saisies
               try{
                   empreinteCarbone = Integer.parseInt(txtEmpreinteCarbon.getText().toString());

               }catch (Exception e) {};
               // contrôle conformité valeur saisie
                if (empreinteCarbone==0) {
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                }else{
                    creationFiche(Produit, Marque, empreinteCarbone, Origine);
                }

            }

        });
    }

    /**
     * Création de la fiche produit
     * @param Produit
     * @param Marque
     * @param EmpreinteCarbone
     * @param Origine
     */
    public void creationFiche(String Produit, String Marque, Integer EmpreinteCarbone, String Origine ){
        this.controle.createProduct(Produit,Marque,EmpreinteCarbone,Origine);

    }


}

