package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Massil on 11/01/2017.
 */

public class FicheMedical implements Serializable{
    @SerializedName("date")
    public Date date;
    @SerializedName("pathologie")
    public Pathologie pathologie;
    @SerializedName("symptome")
    public ArrayList<Symptome> symptomes;
    @SerializedName("phase")
    public Phase phase;
    @SerializedName("exercice")
    public ArrayList<Exercice> exercices;
}
