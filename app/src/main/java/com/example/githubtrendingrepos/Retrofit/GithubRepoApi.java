package com.example.githubtrendingrepos.Retrofit;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GithubRepoApi {

    @GET
    Call<JsonElement> getRepos(@Url String url);

}
