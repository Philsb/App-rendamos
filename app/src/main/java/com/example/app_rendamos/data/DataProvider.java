package com.example.app_rendamos.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.app_rendamos.data.APIClient;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class DataProvider {
    static public APIClient getApiClient(Context context) {
        OkHttpClient.Builder http = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        final Context appContext = context;

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
