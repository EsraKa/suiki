package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.BddModel.Utilisateur;
import com.suiki.suiki.Model.HttpModel.HttpReponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

/**
 * Created by Massil on 18/01/2017.
 */

public interface InscriptionService {
<<<<<<< HEAD
    @POST("Inscrire")
    Call<Inscription> inscrire(@Body Inscription inscription);
=======
    /**
     * Permet l'inscription d'un utilisateur
     * @param utilisateur Utilisateur à inscrire
     * @return HttpResponse
     */
    @PUT("inscription")
    Call<HttpReponse> inscrire(@Body Utilisateur utilisateur);
>>>>>>> f925ce461626516d48ea59339945527be8d30967
}
