package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("index")
    @Expose
    int index;

    @SerializedName("value")
    @Expose
    int value;

    public int getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
