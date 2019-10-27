package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Form {
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("applied")
    @Expose
    boolean applied;

    public Form(int id, String name, boolean applied){
        this.id = id;
        this.name = name;
        this.applied = applied;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getApplied() {
        return applied;
    }
}
