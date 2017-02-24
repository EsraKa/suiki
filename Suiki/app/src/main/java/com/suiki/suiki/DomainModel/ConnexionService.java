package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
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
    @Headers("Content-Type:application/json")
    @POST("connexion/patient")
    Call<HttpReponse> connexion(@Body HttpConnexion connexion);
}
