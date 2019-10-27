package com.example.app_rendamos.data;

import android.util.Log;

import com.example.app_rendamos.data.APIClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProvider {
    static public APIClient getApiClient() {
        OkHttpClient.Builder http = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        http.addInterceptor(logging);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.128.21:8161/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(http.build());
                //.build();

        Retrofit retrofit = builder.build();


        return retrofit.create(APIClient.class);
    }
}
