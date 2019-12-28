package com.codes.amr.nearbyplaces.data.location;

import android.location.Location;

/**
 * Created by ahmedwahdan on 10/20/17.
 */

public class CurrentLocationModel {
   private Location location ;
   private boolean enable ;

    public CurrentLocationModel(Location location, boolean enable) {
        this.location = location;
        this.enable = enable;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "CurrentLocationModel{" +
                "location=" + location +
                ", enable=" + enable +
                '}';
    }
}
