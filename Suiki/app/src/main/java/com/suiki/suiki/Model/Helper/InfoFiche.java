package com.suiki.suiki.Model.Helper;

/**
 * Created by Massil on 15/03/2017.
 */

public class InfoFiche {
    private String date;
    private String phase;
    private String feature;

    public InfoFiche(String feature , String phase , String date) {
        this.feature = feature;
        this.phase = phase;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getPhase() {
        return phase;
    }

    public String getFeature() {
        return feature;
    }
}
