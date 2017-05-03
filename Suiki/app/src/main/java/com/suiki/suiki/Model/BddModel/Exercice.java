package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Massil on 11/01/2017.
 */

public class Exercice implements Serializable{
    @SerializedName("_id")
    public String id;
    @SerializedName("nom")
    public String nom;
    @SerializedName("description")
    public String description;
    @SerializedName("lien")
    public String lien;
}
