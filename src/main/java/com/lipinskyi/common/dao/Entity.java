package com.lipinskyi.common.dao;

public class Entity {

    private int id;
    private String region;
    private String locality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", locality='" + locality + '\'' +
                '}';
    }
}
