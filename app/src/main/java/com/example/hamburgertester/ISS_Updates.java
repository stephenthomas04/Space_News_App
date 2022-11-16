package com.example.hamburgertester;

import java.util.ArrayList;

public class ISS_Updates {
    ArrayList<ISS_Updates> iss_updates;

    public ISS_Updates(ArrayList<ISS_Updates> iss_updates) {
        this.iss_updates = iss_updates;
    }

    public ArrayList<ISS_Updates> getIss_updates() {
        return iss_updates;
    }

    public void setIss_updates(ArrayList<ISS_Updates> iss_updates) {
        this.iss_updates = iss_updates;
    }

    private String title;
    private String websiteUrl;
    private String imageUrl;
    private String summary;
    private String datePublished;

    public ISS_Updates(String title, String websiteUrl, String imageUrl,
                       String summary, String datePublished) {

        this.title = title;
        this.websiteUrl = websiteUrl;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
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

    public String getDatePublished() {
        datePublished = datePublished.substring(0,10);

        return getDatePublished();
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }
}
