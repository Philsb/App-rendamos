package com.example.app_rendamos.data;

import android.util.Log;

import com.example.app_rendamos.data.model.LogInResponse;
import com.example.app_rendamos.data.model.LoggedInUser;
import com.example.app_rendamos.data.model.StudentResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIClient {

    @GET("/ApiServer/api/Student/GetMyStudents")
    Call<List<StudentResponse>> getAllStudents(@Header("Authorization") String authToken);

    @POST("/ApiServer/api/login")
    Call<LogInResponse> logInCall(@Body LoggedInUser body);
}