package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class FloatViewInfo {
    private int locationX;
    private int locationY;
    private long userId;

    public FloatViewInfo(long j, int i, int i2) {
        this.userId = j;
        this.locationX = i;
        this.locationY = i2;
    }

    public int getLocationX() {
        return this.locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setLocationX(int i) {
        this.locationX = i;
    }

    public void setLocationY(int i) {
        this.locationY = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public FloatViewInfo() {
    }
}
