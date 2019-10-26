package com.example.app_rendamos.data;

import com.example.app_rendamos.data.model.APIClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProvider {
    static public APIClient getApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.128.21:8161/ApiServer/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIClient.class);
    }
}
