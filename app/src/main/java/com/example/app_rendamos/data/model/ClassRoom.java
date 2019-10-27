package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassRoom {
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("classYear")
    @Expose
    int classYear;
    @SerializedName("section")
    @Expose
    String section;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("gradeId")
    @Expose
    int gradeId;
    @SerializedName("teacherId")
    @Expose
    int teacherId;

    public int getId() {
        return id;
    }

    public int getClassYear() {
        return classYear;
    }

    public String getSection() {
        return section;
    }

    public String getStatus() {
        return status;
    }

    public int getGradeId() {
        return gradeId;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
