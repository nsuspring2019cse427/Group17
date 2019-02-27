package com.amdadulbari.krishokiot.models;

public class LandModel {
    public double sqft;
    public String landType;
    public double lat;
    public double lon;

    public LandModel(double sqft, String landType, double lat, double lon) {
        this.sqft = sqft;
        this.landType = landType;
        this.lat = lat;
        this.lon = lon;
    }

    public double getSqft() {
        return sqft;
    }

    public void setSqft(double sqft) {
        this.sqft = sqft;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LandModel{" +
                "sqft=" + sqft +
                ", landType='" + landType + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
