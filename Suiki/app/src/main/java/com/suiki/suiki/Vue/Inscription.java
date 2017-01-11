package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.suiki.suiki.R;

import java.io.IOException;


/**
 * Created by Esra on 30/11/2016.
 */

public class Inscription extends Activity {
  private Button valider;
  private EditText nom;
  private EditText prenom;
  private EditText mail;
  private EditText password;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inscription);

    InitialisationObjets();
    InitialisationListeners();
  }

  public void InitialisationObjets()
  {
    valider = (Button)findViewById(R.id.valider);
    nom = (EditText) findViewById(R.id.editNom);
    prenom = (EditText) findViewById(R.id.editPrenom);
    mail = (EditText) findViewById(R.id.editMail);
    password = (EditText) findViewById(R.id.editPassword);
  }

  public void InitialisationListeners()
  {
    valider.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        try {
          Inscrire();
          Intent intent = new Intent(Inscription.this , Connexion.class);
          startActivity(intent);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

  public void Inscrire() throws IOException {
    String NOM = nom.getText().toString();
    String PRENOM = prenom.getText().toString();
    String MAIL = mail.getText().toString();
  }

}
