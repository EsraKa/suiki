package com.suiki.suiki.Dal;

import com.suiki.suiki.Model.BddModel.Personne;
import com.suiki.suiki.Model.BddModel.Utilisateur;
import com.suiki.suiki.Model.HttpModel.HttpInscription;
import com.suiki.suiki.Model.HttpModel.HttpReponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 18/01/2017.
 */

public class InscriptionDal extends BaseDal {
    public void Inscrire(HttpInscription utilisateur)
    {

        Call<HttpReponse> call =
                context.inscriptionService.inscrire(utilisateur);
        /*try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        call.enqueue(new Callback<HttpReponse>() {
            @Override
            public void onResponse(Call<HttpReponse> call, Response<HttpReponse> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<HttpReponse> call, Throwable t) {
                System.err.print(t.getMessage());
            }
        });
    }
}
