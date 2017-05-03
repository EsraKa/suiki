package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

/**
 * Created by Massil on 11/01/2017.
 */

public class Personne {
    @SerializedName("_id")
    public String id;
    @SerializedName("nom")
    public String nom;
    @SerializedName("prenom")
    public String prenom;
    @SerializedName("email")
    public String email;
    @SerializedName("estPatient")
    public static boolean estPatient = true;
}
