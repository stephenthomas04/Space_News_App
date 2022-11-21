package com.example.hamburgertester;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

public class TeamsObj {
    Drawable picture;
    String name;
    String desc;

    public TeamsObj(Drawable picture, String name, String desc) {
        this.picture = picture;
        this.name = name;
        this.desc = desc;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
