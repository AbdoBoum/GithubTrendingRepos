package com.example.githubtrendingrepos.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.githubtrendingrepos.Entities.GitRepo;
import com.example.githubtrendingrepos.R;

import java.util.List;

public class GitAdaprter extends RecyclerView.Adapter<GitAdaprter.GitViewHolder> {

    private Context context;
    private List<GitRepo> repoList;

    public GitAdaprter(Context context, List<GitRepo> repoList) {
        this.context = context;
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_item, viewGroup, false);
        return new GitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int i) {
        GitRepo repo = getItem(i);

        holder.title.setText(repo.getTitle());
        holder.description.setText(repo.getDescription());
        holder.username.setText(repo.getUsername());
        holder.rating.setText(repo.getRating());
        Glide.with(context)
                .load(repo.getAvatarUrl())
                .into(holder.avatar);

    }

    public static class GitViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView description;
        protected TextView username;
        protected TextView rating;
        protected ImageView avatar;

        public GitViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            username = itemView.findViewById(R.id.username);
            rating = itemView.findViewById(R.id.rating);
            avatar = itemView.findViewById(R.id.avatar);
        }
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public GitRepo getItem(int position) {
        return repoList.get(position);
    }

    public void addAllItems(List<GitRepo> repoList) {
        this.repoList = repoList;
        notifyDataSetChanged();
    }
}
