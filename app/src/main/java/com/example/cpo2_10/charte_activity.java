package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.cpo2_10.modele.add_newProduct;
import com.example.cpo2_10.vue.MainActivity;

public class charte_activity extends AppCompatActivity {


    private Button btn_next;
    private ImageButton home_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cette directive enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
// Cette directive permet d'enlever la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_charte_activity);

        btn_next = (Button) findViewById(R.id.btn_next);



        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProduct = new Intent(getApplicationContext(), add_newProduct.class);
                startActivity(addProduct);

            }
        });


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


    }
}
