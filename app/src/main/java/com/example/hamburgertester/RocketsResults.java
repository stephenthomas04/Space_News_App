package com.example.hamburgertester;

import java.util.ArrayList;
import java.util.List;

public class RocketsResults {
    ArrayList<Results> results;

    public RocketsResults(ArrayList<Results> results) {
        this.results = results;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }
}
class Results{
    String name;
    String net;
    Status status;
    Company launch_service_provider;
    Mission mission;
    Pad pad;
    String image;

    public Results(String name, String net, Status status, Company launch_service_provider, Mission mission, Pad pad, String image) {
        this.name = name;
        this.net = net;
        this.status = status;
        this.launch_service_provider = launch_service_provider;
        this.mission = mission;
        this.pad = pad;
        this.image = image;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Company getLaunch_service_provider() {
        return launch_service_provider;
    }

    public void setLaunch_service_provider(Company launch_service_provider) {
        this.launch_service_provider = launch_service_provider;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Pad getPad() {
        return pad;
    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

class Status{
    String abbrev;

    public Status(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
}

class Company{
    String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Mission{
    String description;

    public Mission(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Pad{
    Location location;

    public Pad(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

class Location{
    String name;
    String country_code;

    public Location(String name, String country_code) {
        this.name = name;
        this.country_code = country_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}