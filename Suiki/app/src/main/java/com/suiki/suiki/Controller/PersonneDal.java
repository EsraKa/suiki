package com.suiki.suiki.Controller;

import com.suiki.suiki.Personne;

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
                //throw new Exception(t.getMessage() , t.getCause());
            }
        });
        return lPersonne;
    }

}
