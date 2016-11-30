package com.suiki.suiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;


public class Main extends AppCompatActivity {

  private Intent intent = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    intent = new Intent(Main.this , Menu.class);
    startActivity(intent);
  }
}
