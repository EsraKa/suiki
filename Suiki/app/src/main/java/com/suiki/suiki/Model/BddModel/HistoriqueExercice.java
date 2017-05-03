package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Massil on 03/05/2017.
 */

public class HistoriqueExercice {
    @SerializedName("_id")
    public String id;
    @SerializedName("patient")
    public String patient;
    @SerializedName("note")
    public String note;
    @SerializedName("commentaire")
    public String commentaire;
    @SerializedName("date")
    public Date date;
    @SerializedName("temps")
    public int temps;
    @SerializedName("maj")
    public boolean maj;
}
