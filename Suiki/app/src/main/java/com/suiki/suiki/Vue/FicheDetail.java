package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.FicheMedical;
import com.suiki.suiki.Model.Helper.Adapters.ExpandableAdapter;
import com.suiki.suiki.Model.IntentModel.ListExercice;
import com.suiki.suiki.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Esra on 21/01/2017.
 */

public class FicheDetail extends Activity {

    private TextView pathologieNom;
    private TextView pathologieDescription;
    private CircleImageView phaseIcon;

    private ExpandableListView expandableListView;
    private ExpandableAdapter expandableAdapter;

    private HashMap<String , List<Object>> listDataChild;

    private ArrayList<String> listDataHeader;
    private ArrayList<Object> listDataSymptomes;
    private ArrayList<Object> listDataExercices;

    private FicheMedical ficheMedical;

    SharedPreferences preferences ;

    SharedPreferences.Editor editor;

    private final String SESSION = "SESSION";

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
        prepareListData();
        update();
        setListener();
    }


    private void prepareListData()
    {
        listDataHeader = new ArrayList<>();
        listDataExercices = new ArrayList<>();
        listDataSymptomes = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("Symptomes");
        listDataHeader.add("Exercices");

        listDataExercices.addAll(ficheMedical.exercices);
        listDataSymptomes.addAll(ficheMedical.symptomes);

        System.out.println(listDataExercices);
        System.out.println(listDataSymptomes);

        listDataChild.put(listDataHeader.get(0) , listDataSymptomes);
        listDataChild.put(listDataHeader.get(1) , listDataExercices);

        expandableAdapter = new ExpandableAdapter(this , listDataHeader , listDataChild);
        expandableListView.setAdapter(expandableAdapter);

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
        pathologieNom = (TextView) findViewById(R.id.phaseNom);
        pathologieDescription = (TextView) findViewById(R.id.phaseDescription);

        //Initialisation de l'image de la phase
        phaseIcon = (CircleImageView) findViewById(R.id.phase_icon);

        //Initialisation des liste déroulantes pour symptomes et exercices
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
    }

    //Lancement de tous les libelles
    private void update()
    {
        updateLibelles();
        updateImage();
    }

    private void updateImage()
    {
        switch (ficheMedical.phase.nom)
        {
            case "Phase 1":
                phaseIcon.setImageResource(R.mipmap.phase1);
                break;
            case "Phase 2":
                phaseIcon.setImageResource(R.mipmap.phase2);
                break;
            case "Phase 3":
                phaseIcon.setImageResource(R.mipmap.phase3);
                break;
        }
    }

    //Mise a jour/Remplissage des libelles
    private void updateLibelles()
    {
        //Mise a jour des libelles phase
        pathologieNom.setText(ficheMedical.pathologie.nom);
        pathologieDescription.setText(ficheMedical.pathologie.description);

    }

    /**
     * Ajout de listeners à la ListView fiche Liste Exercice
     * En cas de click, renvoie vers l'activité de détail de l'exercice
     */
    private void setListener()
    {
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if(groupPosition == 1) {
                    ListExercice listExercice = new ListExercice();
                    listExercice.exercices = ficheMedical.exercices;
                    Intent toExercice = new Intent(FicheDetail.this, ExerciceDetail.class);
                    toExercice.putExtra("Exercices", listExercice);
                    toExercice.putExtra("Id" , childPosition);
                    startActivity(toExercice);
                }
                return false;
            }
        });
    }
}

