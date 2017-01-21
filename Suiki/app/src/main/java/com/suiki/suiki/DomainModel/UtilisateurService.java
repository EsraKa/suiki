package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.Utilisateur;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Massil on 18/01/2017.
 */

public interface UtilisateurService {
    @GET("Utilisateur")
    Call<Utilisateur> getUtilisateur(int id);

    @POST("Utilisateur")
    Call<Utilisateur> ajouterUtilisateur(@Body Utilisateur utilisateur);
}
