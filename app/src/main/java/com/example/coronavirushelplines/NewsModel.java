package com.example.coronavirushelplines;

public class NewsModel {

    private String newsPageTile;
    private String newsURL;

    public NewsModel() {
    }

    public NewsModel(String newsPageTile, String newsURL) {
        this.newsPageTile = newsPageTile;
        this.newsURL = newsURL;
    }

    public String getNewsPageTile() {
        return newsPageTile;
    }

    public void setNewsPageTile(String newsPageTile) {
        this.newsPageTile = newsPageTile;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public void setNewsURL(String newsURL) {
        this.newsURL = newsURL;
    }
}
