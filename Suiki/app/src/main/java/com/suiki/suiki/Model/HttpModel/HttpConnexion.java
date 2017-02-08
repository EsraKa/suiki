package com.suiki.suiki.Model.HttpModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Massil on 27/01/2017.
 */

public class HttpConnexion {
    @SerializedName("nom_utilisateur")
    public String nom_utilisateur;
    @SerializedName("mot_de_passe")
    public String mot_de_passe;
}
