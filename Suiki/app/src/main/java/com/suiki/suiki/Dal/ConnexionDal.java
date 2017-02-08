package com.suiki.suiki.Dal;

import com.suiki.suiki.DomainModel.ConnexionService;
import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 27/01/2017.
 */

public class ConnexionDal extends BaseDal {
    private HttpReponse reponse;
    public HttpReponse Connecter(HttpConnexion identifiant)
    {
        Call<HttpReponse> connexion =
                context.connexionService.connexion(identifiant);
        connexion.enqueue(new Callback<HttpReponse>() {
            @Override
            public void onResponse(Call<HttpReponse> call, Response<HttpReponse> response) {
                reponse = response.body();
            }

            @Override
            public void onFailure(Call<HttpReponse> call, Throwable t) {
                System.err.print(t.getStackTrace());
            }
        });
        return reponse;
    }
}
