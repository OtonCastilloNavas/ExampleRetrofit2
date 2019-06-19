package com.cam.exampleretrofit2;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicio {

    private static ServicioAPI INSTANCE;

    public static ServicioAPI getINSTANCE() {
        if(INSTANCE==null)
        {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .client(okHttpClient)
                    .baseUrl("http://10.0.2.2:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            INSTANCE= retrofit.create(ServicioAPI.class);
        }
        return INSTANCE;
    }
}