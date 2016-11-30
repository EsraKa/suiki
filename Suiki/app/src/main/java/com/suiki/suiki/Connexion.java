package com.suiki.suiki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Esra on 30/11/2016.
 */

public class Connexion extends Activity{

  private Button connexion = null;
  private Button inscription = null;
  private Intent intent = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connexion);


    this.connexion = (Button)findViewById(R.id.connexion);
    this.inscription = (Button)findViewById(R.id.inscription);

    this.connexion.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        intent = new Intent(Connexion.this , Profile.class);
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
