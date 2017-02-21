package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Massil on 27/01/2017.
 */

public class Patient implements Serializable {
    @SerializedName("personne")
    public Personne personne;
    @SerializedName("fiches")
    public ArrayList fiches;
}
