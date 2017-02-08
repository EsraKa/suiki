package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by Massil on 11/01/2017.
 */

public class FicheMedical {
    @SerializedName("date")
    public Date date;
    @SerializedName("pathologie")
    public Pathologie pathologie;
    @SerializedName("symptome")
    public Array symptomes;
    @SerializedName("phase")
    public Phase phase;
    @SerializedName("exercice")
    public Array exercices;
}
