package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.suiki.suiki.Controller.ConnexionController;
import com.suiki.suiki.Model.Constants.Session;
import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.R;

/**
 * Created by Esra on 30/11/2016.
 */

public class Connexion extends Activity{

    private Button connexion = null;
    private Button inscription = null;
    private ImageView logo = null;
    private Intent intent = null;
    private HttpConnexion identifiants;
    private TextView username = null;
    private TextView password = null;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editSession;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        Process();
    }

    private void Process()
    {
        Initialisation();
        setSession();
        Listeners();
    }

    private void setSession()
    {
        preferences = getSharedPreferences(Session.PREFERENCES , Context.MODE_PRIVATE);
        editSession = preferences.edit();
    }

    private void Initialisation()
    {
        identifiants = new HttpConnexion();
        this.logo = (ImageView) findViewById(R.id.logo);
        this.connexion = (Button)findViewById(R.id.connexion);
        this.inscription = (Button)findViewById(R.id.inscription);
        this.username = (TextView) findViewById(R.id.editMail);
        this.password = (TextView) findViewById(R.id.editPassword);
    }

    private void Listeners()
    {
        this.connexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            identifiants.nom_utilisateur = username.getText().toString();
            identifiants.mot_de_passe = password.getText().toString();
            intent = new Intent(Connexion.this , AllFiches.class);
            ConnexionController.Connecter(identifiants , intent , Connexion.this , editSession);
            }
        });

        this.inscription.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) {
            intent = new Intent(Connexion.this , Inscription.class);
            startActivity(intent);
          }
        });
    }
}
