package com.suiki.suiki.Dal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.suiki.suiki.Model.BddModel.HistoriqueExercice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 03/05/2017.
 */

public class HistoriqueExerciceDal extends BaseDal {
    public void ajoutHistoriqueExercice(HistoriqueExercice historiqueExercice , final Activity activity)
    {
        Call<HistoriqueExercice> call
                = context.historiqueMedicalService.ajoutHistoriqueExercice(historiqueExercice);
        call.enqueue(new Callback<HistoriqueExercice>() {
            @Override
            public void onResponse(Call<HistoriqueExercice> call, Response<HistoriqueExercice> response) {
                if(response.body() != null)
                {
                    activity.finish();
                }
                else
                {
                    Toast.makeText(activity , "Probleme lors de l'envoie de la note" , Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<HistoriqueExercice> call, Throwable t) {
                Toast.makeText(activity , "Une erreure est survenue" , Toast.LENGTH_LONG);
            }
        });
    }
}
