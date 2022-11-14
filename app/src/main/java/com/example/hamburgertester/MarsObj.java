package com.example.hamburgertester;

import java.util.ArrayList;

public class MarsObj {
    ArrayList<Images> photos;

    public MarsObj(ArrayList<Images> photos) {
        this.photos = photos;
    }

    public ArrayList<Images> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Images> photos) {
        this.photos = photos;
    }
}

class Images{
    String sol;
    String img_src;
    String earth_date;

    public Images(String sol, String img_src, String earth_date) {
        this.sol = sol;
        this.img_src = img_src;
        this.earth_date = earth_date;
    }

    public String getSol() {
        return sol;
    }

    public void setSol(String sol) {
        this.sol = sol;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getEarth_date() {
        return earth_date;
    }

    public void setEarth_date(String earth_date) {
        this.earth_date = earth_date;
    }
}


