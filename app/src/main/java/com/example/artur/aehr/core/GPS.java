package com.example.artur.aehr.core;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.example.artur.aehr.GPS_Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Artur on 2016-05-14.
 */
public class GPS extends Thread implements LocationListener {
    private static GPS gps;
    private static LocationManager lm;
    private Criteria cr;
    private Location loc;
    private String bestProvider;
    private List<Point> history = new LinkedList<Point>();
    private GPS_Activity GPS_actv;
    private List<IActivity> ActivityList;

    @SuppressWarnings("static-access")
    public GPS(LocationManager lm) {

        ActivityList = new LinkedList<IActivity>();
        cr = new Criteria();
        this.lm = lm;
        refresh();
        try {
            lm.requestLocationUpdates(bestProvider, 1000, 2, this); // refresh co
        } catch (SecurityException e) { }        // 1000ms i 2
        // metry
        gps = this;

    }

    public GPS() {
        cr = new Criteria();
        refresh();

        lm.requestLocationUpdates(bestProvider, 1000, 2, this); // refresh co
        // 1000ms i 2
        // metry
        gps = this;
    }

    public static GPS getGPS() {
        if (gps == null)
            gps = new GPS();
        return gps;
    }

    @Override
    public void onLocationChanged(Location location) {
        // Notify
        // add history
        refresh();
        for (IActivity activity : ActivityList) {
            activity.refresh();
        }
//		if (GPS_actv != null)
//			GPS_actv.refresh();

    }

    public double getLongitude() {
        return loc.getLongitude();
    }

    public double getLatitude() {
        return loc.getLatitude();

    }

    public String getBestProvider() {
        return bestProvider;
    }

    public void refresh() {
        bestProvider = lm.getBestProvider(cr, true);
        if (bestProvider != null) {
            loc = lm.getLastKnownLocation(bestProvider);
            history.add(new Point(loc));
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    public void addActivity(IActivity ac) {
        ActivityList.add(ac);
    }

    public void delActivity(IActivity ac) {
        ActivityList.remove((ac));
    }

    public void setGPS_actv(GPS_Activity gPS_actv) {
        GPS_actv = gPS_actv;
    }

    public Location getLoc() {
        return loc;
    }

    public List<Point> getHistory() {
        return history;
    }






}
