package com.suiki.suiki.Model.HttpModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Massil on 27/01/2017.
 */

public class HttpReponse {
    @SerializedName("status")
    public boolean status;
    @SerializedName("data")
    public Object data;
    @SerializedName("error")
    public Object error;
}
