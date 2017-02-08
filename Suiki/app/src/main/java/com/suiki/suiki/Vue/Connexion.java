package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.suiki.suiki.Controller.ConnexionController;
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

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        Process();
    }

    private void Process()
    {
        Initialisation();
        Listeners();
    }

    private void Initialisation()
    {
        this.logo = (ImageView) findViewById(R.id.logo);
        this.connexion = (Button)findViewById(R.id.connexion);
        this.inscription = (Button)findViewById(R.id.inscription);
        this.username = (TextView) findViewById(R.id.editPseudo);
        this.password = (TextView) findViewById(R.id.editPassword);
    }

    private void Listeners()
    {
        this.connexion.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) {
              identifiants.nom_utilisateur = username.getText().toString();
              identifiants.mot_de_passe = password.getText().toString();
              ConnexionController.Connecter(identifiants);
            intent = new Intent(Connexion.this , Calendrier.class);
            startActivity(intent);
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
