package com.example.exam.flo.examproject.services;

import com.example.exam.flo.examproject.domain.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by flo on 01/02/2018.
 */

public class NetworkService {

    public static final String BASE_MAIN_URL = "http://172.20.10.2";
    public static final int BASE_URL_PORT = 4022;
    public static final String BASE_URL = BASE_MAIN_URL + ":" + String.valueOf(BASE_URL_PORT);

    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static NetworkServiceInterface mInstance = null;

    public static NetworkServiceInterface getInstance() {
        if (mInstance == null) {
            mInstance = mRetrofit.create(NetworkServiceInterface.class);
        }
        return mInstance;
    }

    public interface NetworkServiceInterface {
        @GET("/all")
        Call<List<Patient>> getAll();
    }
}
