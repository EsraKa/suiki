package com.suiki.suiki.Dal;

import com.suiki.suiki.Model.Utilisateur;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 18/01/2017.
 */

public class UtilisateurDal extends BaseDal{

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

    public void postUtilisateur(Utilisateur utilisateur)
    {
        Call<Utilisateur> call = context.utilisateurService.ajouterUtilisateur(utilisateur);
        call.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {

            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {

            }
        });
    }
}
