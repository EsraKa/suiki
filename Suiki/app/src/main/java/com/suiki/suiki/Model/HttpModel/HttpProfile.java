package com.suiki.suiki.Model.HttpModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Massil on 21/02/2017.
 */

public class HttpProfile {
    @SerializedName("nom")
    public String nom;

    @SerializedName("prenom")
    public String prenom;

    @SerializedName("email")
    public String email;

    @SerializedName("estPatient")
    private boolean estPatient = true;
}
