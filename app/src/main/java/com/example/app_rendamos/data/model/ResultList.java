package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultList {
    @SerializedName("areaId")
    @Expose
    int areaId;

    @SerializedName("results")
    @Expose
    Results results;

    public int getAreaId() {
        return areaId;
    }

    public Results getResults() {
        return results;
    }
}
