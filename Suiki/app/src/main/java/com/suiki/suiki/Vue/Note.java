package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.suiki.suiki.Controller.HistoriqueExerciceController;
import com.suiki.suiki.Model.BddModel.HistoriqueExercice;
import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Model.Constants.Session;
import com.suiki.suiki.R;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Massil on 03/05/2017.
 */

public class Note extends Activity {

    private EditText commentaire;
    private RatingBar note;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

    }

    private void initialisation()
    {
        commentaire = (EditText) findViewById(R.id.commentaire);
        note = (RatingBar) findViewById(R.id.note);
        valider = (Button) findViewById(R.id.valider);
    }

    private void setListeners()
    {
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoriqueExercice he = new HistoriqueExercice();
                he.commentaire = commentaire.getText().toString();
                he.date = new Date();
                he.maj = true;
                he.note = Integer.toString(note.getNumStars());
                he.patient = getSharedPreferences(Session.PREFERENCES , Context.MODE_PRIVATE).
                        getString(Session.ID_PATIENT , "");

                HistoriqueExerciceController.ajoutHistoriqueExercice(he , Note.this);
            }
        });
    }
}
