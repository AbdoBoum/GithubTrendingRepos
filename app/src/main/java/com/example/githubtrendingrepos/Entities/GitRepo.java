package com.example.githubtrendingrepos.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GitRepo {

    private String title;

    private String description;

    private String avatarUrl;

    private String username;

    private String rating;

}
