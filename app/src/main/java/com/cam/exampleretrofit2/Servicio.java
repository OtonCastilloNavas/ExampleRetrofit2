package com.cam.exampleretrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicio {

    private static ServicioAPI INSTANCE;

    public static ServicioAPI getINSTANCE() {
        if(INSTANCE==null)
        {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("http://10.0.2.2:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            INSTANCE= retrofit.create(ServicioAPI.class);
        }
        return INSTANCE;
    }
}
