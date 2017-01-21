package com.suiki.suiki.Dal;

import com.suiki.suiki.Model.Personne;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 11/01/2017.
 */

public class PersonneDal extends BaseDal{

    private List<Personne> lPersonne;

    public PersonneDal() {
        super();
    }

    public List<Personne> getListPersonnes()
    {
        Call<List<Personne>> callPersonne = context.personneService.getListPersonne();
        callPersonne.enqueue(new Callback<List<Personne>>() {
            @Override
            public void onResponse(Call<List<Personne>> call, Response<List<Personne>> response) {
                lPersonne = response.body();
            }

            @Override
            public void onFailure(Call<List<Personne>> call, Throwable t) {
                System.err.print(t.getMessage());
            }
        });
        return lPersonne;
    }

    public void getPersonne()
    {
        Call<Personne> callPersonne = context.personneService.getPersonne(1);
        callPersonne.enqueue(new Callback<Personne>() {
            @Override
            public void onResponse(Call<Personne> call, Response<Personne> response) {
                System.out.println(response.body().ID_PERSONNE);
                System.out.println(response.body().NOM_PERSONNE);

                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {
                System.err.print(t.getStackTrace());
            }
        });
    }

    public void postPersonne(Personne personne){
        Call<Personne> post = context.personneService.postPersonne(personne);
        post.enqueue(new Callback<Personne>() {
            @Override
            public void onResponse(Call<Personne> call, Response<Personne> response) {

            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {

            }
        });
    }
}
