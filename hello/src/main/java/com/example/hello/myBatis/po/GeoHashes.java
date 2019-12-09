package com.example.hello.myBatis.po;

public class GeoHashes {
    private int id;
    private int userID;
    private String geoString;

    public GeoHashes(){

    }
    public GeoHashes(int userID, String geoString) {
        this.userID = userID;
        this.geoString = geoString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getGeoString() {
        return geoString;
    }

    public void setGeoString(String geoString) {
        this.geoString = geoString;
    }
}
