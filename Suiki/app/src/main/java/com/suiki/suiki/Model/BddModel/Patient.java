package com.suiki.suiki.Model.BddModel;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Massil on 27/01/2017.
 */

public class Patient implements Serializable {
    @SerializedName("_id")
    public String id;
    @SerializedName("personne")
    public Personne personne;
    @SerializedName("all_fiches")
    public ArrayList fiches;

    public static Patient createPatient(LinkedTreeMap<String, Object> data)
    {
        Patient patient;
        Gson gson = new Gson();
        patient = gson.fromJson(
                gson.toJsonTree(data),Patient.class
        );
        return patient;
    }
}
