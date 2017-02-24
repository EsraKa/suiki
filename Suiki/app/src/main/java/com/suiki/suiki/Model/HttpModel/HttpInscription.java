package com.suiki.suiki.Model.HttpModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Massil on 21/02/2017.
 */

public class HttpInscription {
    @SerializedName("nom_utilisateur")
    public String nom_utilisateur;

    @SerializedName("mot_de_passe")
    public String mot_de_passe;

    @SerializedName("profile")
    public HttpProfile profile;
}
