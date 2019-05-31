package com.example.githubtrendingrepos.Managers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.githubtrendingrepos.Adapters.GitAdaprter;
import com.paginate.Paginate;

public class RecyclerViewManager {
    public static void configureRecycleView(Context context, RecyclerView recyclerView, GitAdaprter adapter, Paginate.Callbacks callbacks) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        Paginate.with(recyclerView, callbacks)
                .setLoadingTriggerThreshold(2)
                .addLoadingListItem(true)
                .build();

    }
}
