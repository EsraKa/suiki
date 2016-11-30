package com.suiki.suiki;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by Esra on 30/11/2016.
 */

public class Connexion extends Activity{

  private Button connexion;
  private Button inscription;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connexion);
  }
}
