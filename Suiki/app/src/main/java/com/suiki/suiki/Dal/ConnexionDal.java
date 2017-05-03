package com.suiki.suiki.Dal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.suiki.suiki.DomainModel.ConnexionService;
import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Model.Constants.Session;
import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;
import com.suiki.suiki.Vue.Connexion;

import java.io.IOException;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Massil on 27/01/2017.
 */

public class ConnexionDal extends BaseDal {

    private Intent intentConnexion;
    private Connexion connexionVue;
    private HttpReponse reponse;

    public ConnexionDal(Intent intentConnexion , Connexion connexionVue)
    {
        this.intentConnexion = intentConnexion;
        this.connexionVue = connexionVue;
    }

    public void Connecter(HttpConnexion identifiant , final SharedPreferences.Editor editSession)
    {
        Call<HttpReponse> connexion =
                context.connexionService.connexion(identifiant);
        connexion.enqueue(new Callback<HttpReponse>() {
            @Override
            public void onResponse(Call<HttpReponse> call, Response<HttpReponse> response) {
                try {
                    reponse = response.body();
                    Patient patient =
                            Patient.createPatient((LinkedTreeMap<String , Object>)reponse.data);
                    editSession.putString(Session.ID_PATIENT, patient.id);
                    intentConnexion.putExtra("Patient", patient);
                    connexionVue.startActivity(intentConnexion);
                }
                catch(NullPointerException e)
                {
                    new AlertDialog.Builder(connexionVue)
                            .setTitle("ERREUR")
                            .setMessage("Impossible de se connecter.")
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }

            }

            @Override
            public void onFailure(Call<HttpReponse> call, Throwable t) {

            }
        });
    }

    public HttpReponse getReponse()
    {
        return reponse;
    }
}
