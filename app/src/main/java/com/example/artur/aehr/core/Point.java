package com.example.artur.aehr.core;


import android.location.Location;

import java.util.Date;
/**
 * przechowuje lokacje oraz czas
 *
 */
public class Point {
    //
    private double longitude;
    private double latitude;
    private double altitude;
    private float speed;
    Date date;

    public Point(Location loc, Date date) {
        longitude = loc.getLongitude(); //długość
        latitude = loc.getLatitude();   //szerokość
        altitude = loc.getAltitude();   //wysokość
        speed = loc.getSpeed();
        this.date = date;

    }

    public Point(Location loc) {
        longitude = loc.getLongitude();
        latitude = loc.getLatitude();
        altitude = loc.getAltitude();
        this.date = new Date();


    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Date getDate() {
        return date;
    }

    public double getAltitude() {
        return altitude;
    }

    public float getSpeed() {
        return speed;
    }

}
