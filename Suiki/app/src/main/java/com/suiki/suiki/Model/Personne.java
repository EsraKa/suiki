package com.suiki.suiki.Model;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

/**
 * Created by Massil on 11/01/2017.
 */

public class Personne {
    @SerializedName("ID_PERSONNE")
    public int ID_PERSONNE ;
    @SerializedName("ID_USER")
    public int ID_USER ;
    @SerializedName("NOM_PERSONNE")
    public String NOM_PERSONNE ;
    @SerializedName("PRENOM_PERSONNE")
    public String PRENOM_PERSONNE ;
    @SerializedName("MAIL")
    public String MAIL ;
    @SerializedName("PATIENT_MEDECIN")
    public String PATIENT_MEDECIN ;
}
