package com.example.testlogin.API;
import com.example.testlogin.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import  retrofit2.http.GET;
import  retrofit2.http.POST;
import  retrofit2.http.Part;
import  retrofit2.http.Query;
import  retrofit2.http.QueryMap;
public interface APIService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl("#")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);
    @GET("users")
    Call<List<User>> getListUser (@Query("") String key);

}
