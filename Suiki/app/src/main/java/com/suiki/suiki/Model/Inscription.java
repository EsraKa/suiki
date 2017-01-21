package com.suiki.suiki.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Massil on 21/01/2017.
 */

public class Inscription {
    @SerializedName("Utilisateur")
    public Utilisateur utilisateur;
    @SerializedName("Personne")
    public Personne personne;
}
