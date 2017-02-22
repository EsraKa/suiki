package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.FicheMedical;
import com.suiki.suiki.R;

/**
 * Created by Esra on 21/01/2017.
 */

public class Exercices extends Activity {

    private ListView listExercice;
    private ArrayAdapter<Exercice> arrayAdapterExercice;
    private FicheMedical ficheMedical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercices);
        process();
    }

    private void process()
    {
        initialisation();
        updateListView();
        setListener();
    }

    private void initialisation()
    {
        listExercice = (ListView) findViewById(R.id.listExercice);
        arrayAdapterExercice = new ArrayAdapter<Exercice>(Exercices.this ,
                android.R.layout.simple_expandable_list_item_1);
        ficheMedical = (FicheMedical) getIntent().getSerializableExtra("Fiche");
    }

    private void updateListView()
    {
        for(Exercice exercice : ficheMedical.exercices)
        {
            arrayAdapterExercice.add(exercice);
        }
        listExercice.setAdapter(arrayAdapterExercice);
    }

    private void setListener()
    {
        listExercice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Exercice exercice = ficheMedical.exercices.get(i);
                Intent toExercice = new Intent(Exercices.this , ExerciceDetail.class);
                toExercice.putExtra("Exercice" , exercice);
                startActivity(toExercice);
            }
        });
    }
}

