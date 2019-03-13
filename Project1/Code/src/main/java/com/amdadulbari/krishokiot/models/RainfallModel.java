package com.amdadulbari.krishokiot.models;

public class RainfallModel {
    private  int id;
    private int landId;
    private float rainfallMM;

    public RainfallModel(int id, int landId, float rainfallMM) {
        this.id = id;
        this.landId = landId;
        this.rainfallMM = rainfallMM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    public float getRainfallMM() {
        return rainfallMM;
    }

    public void setRainfallMM(float rainfallMM) {
        this.rainfallMM = rainfallMM;
    }
}
