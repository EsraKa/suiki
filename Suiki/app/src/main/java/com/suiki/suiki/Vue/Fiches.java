package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.FicheMedical;
import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Model.BddModel.Personne;
import com.suiki.suiki.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Massil on 21/02/2017.
 */

public class Fiches extends Activity {

    private ListView listFiches;
    private Patient patient;
    private Toolbar toolbar;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fiches);

        process();
    }

    private void process()
    {
        initialisation();
        updateList();
    }

    private void initialisation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listFiches = (ListView) findViewById(R.id.listFiches);
        Gson gson = new Gson();
        System.out.println(getIntent().getSerializableExtra("Patient"));

        patient = gson.fromJson(
                gson.toJsonTree(getIntent().getSerializableExtra("Patient"))
                , Patient.class
        );

        arrayAdapter = new ArrayAdapter<String>(Fiches.this , android.R.layout.simple_expandable_list_item_1);
    }

    private void updateList()
    {
        if(patient.fiches != null && patient.fiches.size() > 0) {
            ArrayList<FicheMedical> fiches = patient.fiches;
            for (FicheMedical fiche : fiches) {
                arrayAdapter.add(fiche.date.toString());
            }
            listFiches.setAdapter(arrayAdapter);
        }
    }

    private void setListeners()
    {
        listFiches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FicheMedical fiche = (FicheMedical) patient.fiches.get(i);
                Intent toExercice = new Intent(Fiches.this , Exercices.class);
                toExercice.putExtra("Fiche" , fiche );
                startActivity(toExercice);
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Coucou");
            }
        });
    }
}
