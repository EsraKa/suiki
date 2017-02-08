package com.suiki.suiki.Dal;

import com.suiki.suiki.DomainModel.ConnexionService;
import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;

import java.io.IOException;

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
        try {
            reponse = connexion.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponse;
    }
}
