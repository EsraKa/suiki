package com.suiki.suiki.Dal;

import android.util.Pair;

import com.suiki.suiki.Model.Inscription;
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
        Inscription inscription = new Inscription();
        inscription.personne = personne;
        inscription.utilisateur = utilisateur;
        Call<Inscription> call =
                context.inscriptionService.inscrire(inscription);
        call.enqueue(new Callback<Inscription>() {
            @Override
            public void onResponse(Call<Inscription> call, Response<Inscription> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<Inscription> call, Throwable t) {
                System.err.print(t.getMessage());
            }
        });
    }
}
