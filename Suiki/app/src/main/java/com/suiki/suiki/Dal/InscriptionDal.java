package com.suiki.suiki.Dal;

import android.util.Pair;

import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.Model.Utilisateur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 18/01/2017.
 */

public class InscriptionDal extends BaseDal {
    public void Inscrire(Utilisateur utilisateur , Personne personne)
    {
        Call<Pair<Utilisateur , Personne>> call =
                context.inscriptionService.inscrire(new Pair<Utilisateur , Personne>(utilisateur , personne));
        call.enqueue(new Callback<Pair<Utilisateur, Personne>>() {
            @Override
            public void onResponse(Call<Pair<Utilisateur, Personne>> call, Response<Pair<Utilisateur, Personne>> response) {

            }

            @Override
            public void onFailure(Call<Pair<Utilisateur, Personne>> call, Throwable t) {

            }
        });
    }
}
