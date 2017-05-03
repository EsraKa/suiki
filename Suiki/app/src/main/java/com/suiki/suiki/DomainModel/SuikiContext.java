package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Vue.Connexion;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Massil on 11/01/2017.
 */

public class SuikiContext {
    private Retrofit context;

    public InscriptionService inscriptionService;
    public ConnexionService connexionService;
    public HistoriqueExerciceService historiqueMedicalService;

    public SuikiContext()
    {
        context = new Retrofit.Builder()
                .baseUrl("http://213.32.33.136:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        inscriptionService = context.create(InscriptionService.class);
        connexionService = context.create(ConnexionService.class);
        historiqueMedicalService = context.create(HistoriqueExerciceService.class);
    }
}
