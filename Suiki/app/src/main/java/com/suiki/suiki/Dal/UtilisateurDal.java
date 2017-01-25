package com.suiki.suiki.Dal;

import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.Model.Utilisateur;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 18/01/2017.
 */

public class UtilisateurDal extends BaseDal{

    private Personne profile;

    public void getUtilisateur(int id)
    {
        Utilisateur resultat;
        Call<Utilisateur> callUtilisateur = context.utilisateurService.getUtilisateur(id);
        callUtilisateur.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {

            }
        });
    }

    public void connexionUtilisateur(Utilisateur utilisateur)
    {
        Call<Personne> call = context.utilisateurService.connexionUtilisateur(utilisateur);
        call.enqueue(new Callback<Personne>() {
            @Override
            public void onResponse(Call<Personne> call, Response<Personne> response) {
                profile = response.body();
            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {

            }
        });
    }

    public Personne getProfile()
    {
        return profile;
    }
}
