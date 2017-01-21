package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.Utilisateur;

import okhttp3.internal.Util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Massil on 11/01/2017.
 */

public class SuikiContext {
    private Retrofit context;
    public PersonneService personneService;
    public UtilisateurService utilisateurService;
    public InscriptionService inscriptionService;

    public SuikiContext()
    {
        context = new Retrofit.Builder()
                .baseUrl("http://192.168.43.186/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        personneService = context.create(PersonneService.class);
        utilisateurService = context.create(UtilisateurService.class);
        inscriptionService = context.create(InscriptionService.class);
    }
}
