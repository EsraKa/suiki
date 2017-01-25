package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.Model.Utilisateur;

import okhttp3.internal.Util;
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
    Call<Personne> connexionUtilisateur (@Body Utilisateur utilisateur);

    @POST("Utilisateur")
    Call<Utilisateur> ajouterUtilisateu(@Body Utilisateur utilisateur);
}
