package com.suiki.suiki.Vue.Helper.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.suiki.suiki.Vue.AllFiches;
import com.suiki.suiki.Vue.FicheDetail;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Massil on 13/04/2017.
 */

public class FicheEnCoursFragment extends Fragment {
    private ListView listFiches;
    private ListView ancienneListFiches;
    private Patient patient;
    private Toolbar toolbar;
    private ArrayList<InfoFiche> listInfoFiche;
    private ArrayAdapter<String> arrayAdapter;

    private FicheCustomAdapter ficheCustomAdapter;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fiche_en_cours, container , false);
        process();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void process()
    {
        initialisation();
        updateList();
        setListeners();
    }

    private void initialisation()
    {
        patient = (Patient) getArguments().getSerializable("Patient");
        listFiches = (ListView) view.findViewById(R.id.listFiches);
        ancienneListFiches = (ListView) view.findViewById(R.id.ancienneListFiches);

        listInfoFiche = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_activated_1);
    }

    private void updateList()
    {
        FicheMedical lastFiche = null;
        if(patient.fiches != null && patient.fiches.size() > 0) {
            ArrayList<FicheMedical> fiches = patient.fiches;
            for (FicheMedical fiche : fiches) {
                if(lastFiche == null)
                {
                    lastFiche = fiche;
                }
                else
                {
                    if(lastFiche.date.compareTo(fiche.date)>-1)
                    {
                        lastFiche = fiche;
                    }
                }
            }
            arrayAdapter.add(lastFiche.date.toString());
            listFiches.setAdapter(arrayAdapter);
        }
    }

    private void setListeners()
    {
        listFiches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FicheMedical fiche = (FicheMedical) patient.fiches.get(i);
                Intent toExercice = new Intent(getActivity().getApplicationContext() , FicheDetail.class);
                toExercice.putExtra("FicheDetail" , fiche);
                startActivity(toExercice);
            }
        });
    }
}
