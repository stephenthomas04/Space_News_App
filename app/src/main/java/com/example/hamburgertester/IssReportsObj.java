package com.example.hamburgertester;

public class IssReportsObj {
    String title;
    String url;
    String imageUrl;
    String summary;


    public IssReportsObj(String reportTitle, String reportUrl, String imageUrl, String summary) {
        this.title = reportTitle;
        this.url = reportUrl;
        this.imageUrl = imageUrl;
        this.summary = summary;
    }

    public String getReportTitle() {
        return title;
    }

    public void setReportTitle(String reportTitle) {
        this.title = reportTitle;
    }

    public String getReportUrl() {
        return url;
    }

    public void setReportUrl(String reportUrl) {
        this.url = reportUrl;
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
}
