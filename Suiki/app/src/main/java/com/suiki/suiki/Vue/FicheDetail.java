package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.FicheMedical;
import com.suiki.suiki.Model.BddModel.Symptome;
import com.suiki.suiki.Model.Helper.Adapters.SymptomeCustomAdapter;
import com.suiki.suiki.Model.Helper.DrawerItemClickListener;
import com.suiki.suiki.R;

import java.util.List;

/**
 * Created by Esra on 21/01/2017.
 */

public class FicheDetail extends Activity {

    private TextView phaseNom;
    private TextView phaseDescription;
    private TextView pathologieNom;
    private TextView pathologieDescription;

    private ListView listSymptomes;
    private ListView listExercice;

    private ArrayAdapter<String> arrayAdapterExercice;
    private SymptomeCustomAdapter symptomeAdapter;

    private FicheMedical ficheMedical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fiche);
        process();
    }

    /**
     * Processus d'initialisation et de lancement des composants de l'application
     */
    private void process()
    {
        initialisation();
        update();
        setListener();
    }

    /**
     * Initialisation de l'application
     * Récupération des éléments tel que TextView ou ListView
     */
    private void initialisation()
    {
        //Récupération de la fiche médical du dernier intent
        ficheMedical = (FicheMedical) getIntent().getSerializableExtra("FicheDetail");

        // Initialisation des libellés
        phaseNom = (TextView) findViewById(R.id.phaseNom);
        phaseDescription = (TextView) findViewById(R.id.phaseDescription);

        pathologieNom = (TextView) findViewById(R.id.pathologieNom);
        pathologieDescription = (TextView) findViewById(R.id.pathologieDescription);

        //Initialisation de la liste des symptomes
        listSymptomes = (ListView) findViewById(R.id.listSymptomes);
        symptomeAdapter = new SymptomeCustomAdapter(ficheMedical.symptomes , FicheDetail.this );

        //Initialisation de la liste des exercices
        listExercice = (ListView) findViewById(R.id.listExercice);
        arrayAdapterExercice = new ArrayAdapter<String>(FicheDetail.this ,
                android.R.layout.simple_expandable_list_item_1);
    }

    //Lancement de tous les libelles
    private void update()
    {
        updateLibelles();
        updateListViews();
    }

    //Mise a jour/Remplissage des libelles
    private void updateLibelles()
    {
        //Mise a jour des libelles phase
        phaseNom.setText(ficheMedical.phase.nom);
        phaseDescription.setText(ficheMedical.phase.description);

        //Mise a jour des libelles pathologie
        pathologieNom.setText(ficheMedical.pathologie.nom);
        pathologieDescription.setText(ficheMedical.pathologie.description);

    }

    /**
     * Mise à jour du composant ListView
     */
    private void updateListViews()
    {
        updateListSymptomes();
        updateListExercices();
    }

    // Mise à jour/Remplissage de la liste des symptomes
    private void updateListSymptomes()
    {
        listSymptomes.setAdapter(symptomeAdapter);
    }

    // Mise à jour/Remplissage de la liste des exercices
    private void updateListExercices()
    {
        for(Exercice exercice : ficheMedical.exercices)
        {
            arrayAdapterExercice.add(exercice.nom);
        }
        System.out.print(arrayAdapterExercice.getCount());
        listExercice.setAdapter(arrayAdapterExercice);
    }


    /**
     * Ajout de listeners à la ListView fiche Liste Exercice
     * En cas de click, renvoie vers l'activité de détail de l'exercice
     */
    private void setListener()
    {
        listExercice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Exercice exercice = ficheMedical.exercices.get(i);
                Intent toExercice = new Intent(FicheDetail.this , ExerciceDetail.class);
                toExercice.putExtra("Exercice" , exercice);
                startActivity(toExercice);
            }
        });
    }
}

