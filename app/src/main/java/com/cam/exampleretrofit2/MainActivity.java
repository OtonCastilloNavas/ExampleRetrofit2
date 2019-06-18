package com.cam.exampleretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        final TextView ettexto= findViewById(R.id.ettexto);
        ServicioAPI servicioAPI = Servicio.getINSTANCE();

        Clase clase = new Clase();
        clase.setCredito(2);
        clase.setNombre("IA");
        Call<Clase> claseCall = servicioAPI.createClases(clase);
        claseCall.enqueue(new Callback<Clase>() {
            @Override
            public void onResponse(Call<Clase> call, Response<Clase> response) {
                if(response.isSuccessful())
                {
                    ettexto.setText(response.message());
                }
                try {
                    ettexto.setText("regreso:" + response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Clase> call, Throwable t) {
                ettexto.setText(t.toString());
            }
        });

        //UNO
    //        Call<Clase> claseCall= servicioAPI.getClase(3);
    //       claseCall.enqueue(new Callback<Clase>() {
    //           @Override
    //           public void onResponse(Call<Clase> call, Response<Clase> response) {
    //               if(response.isSuccessful())
    //               {
    //                   TextView ettexto= findViewById(R.id.ettexto);
    //                   ettexto.setText(response.body().getNombre());
    //               }
    //           }
    //
    //           @Override
    //           public void onFailure(Call<Clase> call, Throwable t) {
    //               TextView ettexto= findViewById(R.id.ettexto);
    //               ettexto.setText(t.toString());
    //           }
    //       });

        //varios
//        Call<List<Clase>>claseCall= servicioAPI.getData();
//        claseCall.enqueue(new Callback<List<Clase>>() {
//            @Override
//            public void onResponse(Call<List<Clase>> call, Response<List<Clase>> response) {
//                TextView ettexto= findViewById(R.id.ettexto);
//                ettexto.setText(String.valueOf(response.body().size()));
//            }
//
//            @Override
//            public void onFailure(Call<List<Clase>> call, Throwable t) {
//                TextView ettexto= findViewById(R.id.ettexto);
//                ettexto.setText(t.getMessage().toString());
//            }
//        });


    }
}
