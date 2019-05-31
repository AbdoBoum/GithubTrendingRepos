package com.example.githubtrendingrepos.Fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubtrendingrepos.Activities.MainActivity;
import com.example.githubtrendingrepos.Adapters.GitAdaprter;
import com.example.githubtrendingrepos.Entities.GitRepo;
import com.example.githubtrendingrepos.Helper.Utils;
import com.example.githubtrendingrepos.Managers.RecyclerViewManager;
import com.example.githubtrendingrepos.R;
import com.example.githubtrendingrepos.Retrofit.GithubRepoApi;
import com.example.githubtrendingrepos.Retrofit.Retrofit2Client;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingFragment extends Fragment {

    private MainActivity activity;

    private RecyclerView mainRecyclerView;
    private GitAdaprter adapter;

    List<GitRepo> repoList;

    int page = 0;

    private static final String TAG = "TrendingFragment";

    public static TrendingFragment newInstance() {
        TrendingFragment fragment = new TrendingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repos_fragmenet, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        activity = (MainActivity) getActivity();
        init();
    }

    private void init() {
        activity = (MainActivity) getActivity();
        adapter = new GitAdaprter(activity.getApplicationContext(), repoList);
        RecyclerViewManager.configureRecycleView(activity, mainRecyclerView);
        mainRecyclerView.setAdapter(adapter);
        getData();
    }

    private void getData() {
        String url = "search/repositories?q=created:>" + Utils.getFormattedDateOneMonthAgo() + "&sort=stars&order=desc&page=" + page;

        GithubRepoApi api = Retrofit2Client.getService();

        api.getRepos(url).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(!response.isSuccessful()) {
                    Utils.makeToast(activity.getApplicationContext(), String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Utils.makeToast(activity.getApplicationContext(), t.getMessage());
            }
        });
    }

    private void refreshRecyclerView() {
        adapter.addAllItems(repoList);
    }
}
