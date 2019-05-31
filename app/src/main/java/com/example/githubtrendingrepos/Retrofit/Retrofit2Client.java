package com.example.githubtrendingrepos.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.githubtrendingrepos.Helper.Utils.BASE_URL;

public class Retrofit2Client {

    private static Retrofit2Client instance = null;
    private Retrofit retrofit;

    private GithubRepoApi exploreService;

    public Retrofit2Client() {


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        exploreService = retrofit.create(GithubRepoApi.class);
    }

    public static Retrofit2Client getInstance() {
        if (instance == null) {
            instance = new Retrofit2Client();
        }

        return instance;
    }

    public GithubRepoApi getExploreService() {
        return exploreService;
    }
}
