package com.example.cpo2_10.modele;

import android.util.Log;

import com.example.cpo2_10.outils.AccesHTTP;
import com.example.cpo2_10.outils.AsyncResponse;

import org.json.JSONArray;

public class AccesDistant implements AsyncResponse {

    // constante
    private static final String SERVERADDR = "http://192.168.1.59/cpo2/test.php";

public AccesDistant(){
    super();
}

    /**
     * retour du serveur distant
     * @param output
     */

    @Override
    public void processFinish(String output) {
        Log.d("serveur","*************"+output); // permet l'affichage des erreurs php
        // découpage du message reçu
        String[] message = output.split("%");
        // dans message[0] : soit "enreg", soit "dernier" , soit "erreur"
        // dans message [1] : reste du message

        // s'il y'a 2 cases :
        if (message.length>1){
            if(message[0].equals("enreg")){
                Log.d("enreg", "*************"+message[1]);
            }else{
                if(message[0].equals("dernier")){
                    Log.d("dernier", "*************"+message[1]);
                }else {
                    if(message[0].equals("Erreur !")){
                        Log.d("Erreur !", "*************"+message[1]);
                    }
                }
            }
        }
    }


    public void envoi(String operation, JSONArray lesDonneesJSON){

        AccesHTTP accesDonnees = new AccesHTTP();

        // lien de délégation
        accesDonnees.delegate = this;

        // ajout parametre
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());

        // appel au serveur
        accesDonnees.execute(SERVERADDR);
    }



}
