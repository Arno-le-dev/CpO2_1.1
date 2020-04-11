package com.example.cpo2_10;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;

import com.example.cpo2_10.vue.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.cpo2_10.vue.MainActivity.maBase;

public class resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
    }



    final ArrayList<FicheProduit> fiches = new ArrayList<FicheProduit>();


    Cursor c = maBase.rawQuery("select * from fiche by note desc limit 1;", null);


}
