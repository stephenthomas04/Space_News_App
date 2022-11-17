package com.example.hamburgertester;

import java.util.ArrayList;

public class ISS_Updates {
    String title;
    String url;
    String imageUrl;
    String summary;
    String date;

    public ISS_Updates(String title, String url, String imageUrl, String summary, String date) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
