package com.suiki.suiki.DomainModel;

import com.suiki.suiki.Model.BddModel.HistoriqueExercice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Massil on 03/05/2017.
 */

public interface HistoriqueExerciceService {
    @Headers("Content-Type:application/json")
    @POST("/CreationHistorique")
    Call<HistoriqueExercice> ajoutHistoriqueExercice(@Body HistoriqueExercice historiqueExercice);
}
