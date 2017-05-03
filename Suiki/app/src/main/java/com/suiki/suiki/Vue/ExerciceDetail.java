package com.suiki.suiki.Vue;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.Helper.Chronometer;
import com.suiki.suiki.Model.IntentModel.ListExercice;
import com.suiki.suiki.R;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Massil on 21/02/2017.
 */

public class ExerciceDetail extends Activity {

    private boolean play = false;
    private GifImageView imageExercice;

    private Toolbar toolbar;

    private Button imagePlay;
    private Button imageNext;
    private Button imagePrevious;

    private android.widget.Chronometer chronometer;

    private ListExercice listExercice;
    private int idExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_detail);

        initialisation();
        setListeners();
        updateValues();
    }

    private void initialisation()
    {
        imageExercice = (GifImageView) findViewById(R.id.gif);
        imageNext = (Button) findViewById(R.id.arrow_right);
        imagePrevious = (Button) findViewById(R.id.arrow_left);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        imagePlay = (Button) findViewById(R.id.play);

        chronometer = (android.widget.Chronometer) findViewById(R.id.chronometer);

        listExercice = (ListExercice) getIntent().getSerializableExtra("Exercices");
        idExercice = (int) getIntent().getShortExtra("Id" , (short)0);
    }

    private void updateValues()
    {
        Exercice exercice = listExercice.exercices.get(idExercice);
        toolbar.setTitle(exercice.nom);
        imageExercice.setImageResource(R.mipmap.lombalgie_02);
    }

    private void setListeners()
    {
        imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play = !play;
                if(!play)
                {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.stop();
                }
                else
                {
                    chronometer.start();
                }
            }
        });

        imagePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idExercice > 0)
                    idExercice--;
                updateValues();
            }
        });

        imageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idExercice<listExercice.exercices.size()-1)
                    idExercice++;
                updateValues();
            }
        });
    }
}
