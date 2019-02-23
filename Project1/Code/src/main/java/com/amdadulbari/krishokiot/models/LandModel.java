package com.amdadulbari.krishokiot.models;

public class LandModel {
    public int sqft;
    public String landType;
    public float lat;
    public float lon;

    public int getSqft() {
        return sqft;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
