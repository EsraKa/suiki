package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.suiki.suiki.R;

/**
 * Created by Esra on 30/11/2016.
 */

public class Connexion extends Activity{

  private Button connexion = null;
  private Button inscription = null;
  private ImageView logo = null;
  private Intent intent = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connexion);
    logo = (ImageView) findViewById(R.id.logo);
    Process();
  }

  private void Process()
  {
    Initialisation();
    Listeners();
  }

  private void Initialisation()
  {
    this.connexion = (Button)findViewById(R.id.connexion);
    this.inscription = (Button)findViewById(R.id.inscription);
  }

  private void Listeners()
  {
    this.connexion.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
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
