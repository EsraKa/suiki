package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.suiki.suiki.R;

/**
 * Created by Esra on 21/01/2017.
 */

public class Calendrier extends Activity{

  private Button calendrier = null;
  private Button exercice = null;
  private Button profile = null;
  private CalendarView calendarView = null;
  private Intent intent = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.calendrier);
    Process();
  }

  private void Process(){
    Initialisation();
    Listeners();
  }

  private void Initialisation(){
    this.calendrier = (Button)findViewById(R.id.calendrier);
    this.exercice = (Button)findViewById(R.id.exercice);
    this.profile = (Button)findViewById(R.id.profile);

  }

  private void Listeners(){
    this.calendrier.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        intent = new Intent(Calendrier.this , Calendrier.class);
        startActivity(intent);
      }
    });

    this.exercice.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        intent = new Intent(Calendrier.this , FicheDetail.class);
        startActivity(intent);
      }
    });

    this.profile.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        intent = new Intent(Calendrier.this , Profile.class);
        startActivity(intent);
      }
    });
  }
}
