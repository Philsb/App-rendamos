package com.example.app_rendamos.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsResponse {
    @SerializedName("attendanceId")
    @Expose
    int attendanceId;

    @SerializedName("resultList")
    @Expose
    ResultList resultList;

    public int getAttendanceId() {
        return attendanceId;
    }

    public ResultList getResultList() {
        return resultList;
    }
}
