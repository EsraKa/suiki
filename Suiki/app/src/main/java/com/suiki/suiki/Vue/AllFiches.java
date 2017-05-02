package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.FicheMedical;
import com.suiki.suiki.Model.BddModel.Pathologie;
import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Model.BddModel.Phase;
import com.suiki.suiki.Model.BddModel.Symptome;
import com.suiki.suiki.Model.Helper.Adapters.FicheCustomAdapter;
import com.suiki.suiki.Model.Helper.InfoFiche;
import com.suiki.suiki.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Massil on 21/02/2017.
 */

public class AllFiches extends Activity {

    private ListView listFiches;
    private ListView ancienneListFiches;
    private Patient patient;
    private Toolbar toolbar;
    private ArrayList<InfoFiche> listInfoFiche;
    private ArrayAdapter<String> arrayAdapter;
    private FicheCustomAdapter ficheCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_fiches);

        process();
    }

    private void process()
    {
        initialisation();
        //updateList();
        testInitialisation();
        setListeners();
    }

    private void initialisation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listFiches = (ListView) findViewById(R.id.listFiches);
        ancienneListFiches = (ListView) findViewById(R.id.ancienneListFiches);

        listInfoFiche = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(AllFiches.this , android.R.layout.simple_list_item_activated_1);

        /*Gson gson = new Gson();
        System.out.println(getIntent().getSerializableExtra("Patient"));

        patient = gson.fromJson(
                gson.toJsonTree(getIntent().getSerializableExtra("Patient"))
                , Patient.class
        );*/
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
                Intent toExercice = new Intent(AllFiches.this , FicheDetail.class);
                toExercice.putExtra("FicheDetail" , fiche);
                startActivity(toExercice);
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void testInitialisation()
    {
        patient = new Patient();
        patient.fiches = new ArrayList();

        for(int i = 0 ; i < 10 ; i++)
        {
            FicheMedical fm = new FicheMedical();
            Pathologie pat = new Pathologie();
            Phase phase = new Phase();
            Symptome symptome = new Symptome();

            fm.exercices = new ArrayList<>();
            for(int j = i ; j < 10 ; j++)
            {
                Exercice ex = new Exercice();
                ex.description = "Description " + j;
                ex.nom = "Nom " + j;
                ex.lien = "Lien " + j;
                fm.exercices.add(ex);
            }

            phase.nom = "Phase 1";
            phase.description = "Description phase 1";
            fm.phase = phase;

            fm.date = new Date();

            pat.description = "Description pathologie";
            pat.nom = "Nom pathologie";
            fm.pathologie = pat;

            symptome.description = "Description symptome";
            symptome.nom = "Nom symptome";
            fm.symptomes= new ArrayList<>();
            fm.symptomes.add(symptome);
            patient.fiches.add(fm);
            arrayAdapter.add(fm.phase.nom + "\n" + fm.date.toString());
            listInfoFiche.add(new InfoFiche(null , fm.phase.nom , fm.date.toString()));
        }
        ficheCustomAdapter = new FicheCustomAdapter(listInfoFiche , AllFiches.this);
        listFiches.setAdapter(ficheCustomAdapter);
    }
}
