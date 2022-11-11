package com.example.hamburgertester;

public class ISS_Updates {

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
