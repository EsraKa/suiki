package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Personne;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Massil on 11/01/2017.
 */

public interface PersonneService {

    @GET("Personne")
    Call<List<Personne>>  getListPersonne();
    @GET("Personne/{id}")
    Call<Personne> getPersonne(@Path("id") int id);
}
