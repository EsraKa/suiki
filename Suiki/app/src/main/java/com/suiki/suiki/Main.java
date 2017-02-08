package com.suiki.suiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.suiki.suiki.Vue.Connexion;


public class Main extends AppCompatActivity {

  private Intent intent = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    intent = new Intent(Main.this , Connexion.class);
    startActivity(intent);
  }
}
