package com.example.hamburgertester;

public class ApodObj {
    private String date;
    private String explanation;
    private String url;

    private String title;

    public ApodObj(String date, String explanation, String url, String title) {
        this.date = date;
        this.explanation = explanation;
        this.url = url;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String exp) {
        this.explanation = explanation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public  String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
