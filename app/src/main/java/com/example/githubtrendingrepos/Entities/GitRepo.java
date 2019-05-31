package com.example.githubtrendingrepos.Entities;

public class GitRepo {

    private String title;

    private String description;

    private String avatarUrl;

    private String username;

    private String rating;

    public GitRepo(String title, String description, String avatarUrl, String username, String rating) {
        this.title = title;
        this.description = description;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
