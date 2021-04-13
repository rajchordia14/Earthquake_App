package com.example.android.quakereport;

public class Earthquake {
    private Double magnitude;

    // @param city location of earthquake
    private String location;

    // @param date , the  date of the earthquake
    private long time;

    public Earthquake(Double magnitude, String location, long time) {
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long gettimemili() {
        return time;
    }


}
