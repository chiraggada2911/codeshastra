package com.example.myapplication.rest;

import com.example.myapplication.Checkpogo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("api/")
    Call<List<Checkpogo>> login();

    @PUT("api/updateapplied/{id}")
    Call<List<Checkpogo>> update(@Path("id") String id);
}
