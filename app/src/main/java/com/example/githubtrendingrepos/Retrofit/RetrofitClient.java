package com.example.githubtrendingrepos.Retrofit;

import lombok.Getter;
import lombok.Setter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Getter
@Setter
public class RetrofitClient {

    private Retrofit retrofit;
    private String baseUrl;

    public RetrofitClient(String baseUrl) {
        this.baseUrl = baseUrl;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
