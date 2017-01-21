package com.suiki.suiki.DomainModel;

import android.util.Pair;

import com.suiki.suiki.Model.Inscription;
import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.Model.Utilisateur;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Massil on 18/01/2017.
 */

public interface InscriptionService {
    @POST
    Call<Inscription> inscrire(@Body Inscription inscription);
}
