package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Massil on 27/01/2017.
 */

public interface ConnexionService {
    /**
     * Permet de vérifier les identifiants de connexion
     * @param connexion identifiant de connexion
     * @return HttpResponse
     */
    @POST("connexion")
    Call<HttpReponse> connexion(@Body HttpConnexion connexion);
}
