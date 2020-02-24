package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

