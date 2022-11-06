package com.example.hamburgertester;

public class NewsObj {
    String title;
    String url;
    String imageUrl;
    String summary;
    String publishedAt;
    String newsSite;

    public NewsObj(String title, String url, String imageUrl, String summary, String publishedAt, String newsSite) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.newsSite = newsSite;
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

    public String getPublishedAt() {
        publishedAt = publishedAt.substring(0,10);

        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }


}
