package com.disabngo.blockynexus.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UserMapInfo implements Serializable {
    private double distance;
    private double latitude;
    private double longitude;
    private String pic;
    private long userId;
    private int x;
    private int y;

    public UserMapInfo() {
    }

    public double getDistance() {
        return this.distance;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPic() {
        return this.pic;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setDistance(double d2) {
        this.distance = d2;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setX(int i) {
        this.x = i;
    }

    public void setY(int i) {
        this.y = i;
    }

    public UserMapInfo(double d2, double d3, String str, long j) {
        this.latitude = d2;
        this.longitude = d3;
        this.pic = str;
        this.userId = j;
    }
}
