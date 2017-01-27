package com.suiki.suiki.Model.BddModel;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

/**
 * Created by Massil on 27/01/2017.
 */

public class Patient {
    @SerializedName("personne")
    public Personne personne;
    @SerializedName("fiches")
    public Array fiches;
}
