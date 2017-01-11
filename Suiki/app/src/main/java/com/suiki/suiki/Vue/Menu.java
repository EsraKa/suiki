package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.suiki.suiki.Vue.Profile;
import com.suiki.suiki.R;

/**
 * Created by loick on 30/11/2016.
 */

public class Menu  extends Activity{

    private  Button calendrier = null;
    private  Button exercice = null;
    private  Button profile = null;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        this.calendrier = (Button)findViewById(R.id.calendrier);
        this.exercice = (Button)findViewById(R.id.exercice);
        this.profile = (Button)findViewById(R.id.profile);

        this.calendrier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent = new Intent(Menu.this , Profile.class);
                startActivity(intent);
            }
        });

        this.exercice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Todo
            }
        });

        this.profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Todo
            }
        });
    }
}
