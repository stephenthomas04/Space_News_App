package com.example.hamburgertester;

import android.graphics.drawable.Drawable;

public class Planet {
    String planetName;
    String planetInfo;
    Drawable planetImage;

    public Planet(String planetName, String planetInfo, Drawable planetImage) {
        this.planetName = planetName;
        this.planetInfo = planetInfo;
        this.planetImage = planetImage;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetInfo() {
        return planetInfo;
    }

    public void setPlanetInfo(String planetInfo) {
        this.planetInfo = planetInfo;
    }

    public Drawable getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(Drawable planetImage) {
        this.planetImage = planetImage;
    }
}
