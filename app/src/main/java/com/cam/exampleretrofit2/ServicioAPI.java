package com.cam.exampleretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ServicioAPI {
    @GET("clases")
    Call<List<Clase>> getData();

    @GET("clases/{id}")
    Call<Clase> getClase(
            @Path("id") int id);

    @POST("clases")
    Call<Clase> createClases(@Body Clase clase);
}