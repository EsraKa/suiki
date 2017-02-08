package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Massil on 11/01/2017.
 */

public class Utilisateur {
    @SerializedName("nom_utilisateur")
    public String nom_utilisateur ;
    @SerializedName("mot_de_passe")
    public String mot_de_passe ;
    @SerializedName("profile")
    public Personne profile;
}
