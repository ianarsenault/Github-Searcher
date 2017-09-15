package com.githubsearch.githubsearch;

/**
 * Created by ianarsenault on 9/15/17.
 */

public class RepoInformation {
    public String name;
    public String description;
    public String url;
    public String lastUpdated;
    public int forkCount;
    public String language;

    public RepoInformation() { super(); }

    public RepoInformation(String name, String description, String url, String lastUpdated, int forkCount, String language) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.lastUpdated = lastUpdated;
        this.forkCount = forkCount;
        this.language = language;
    }
}
