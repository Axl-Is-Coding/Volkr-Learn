package com.sandboxol.center.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DressWeekRecommendInfo implements Serializable {
    private int appVersion;
    private String picUrl;
    private int sex;
    private long suitId;

    public int getAppVersion() {
        return this.appVersion;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getSex() {
        return this.sex;
    }

    public long getSuitId() {
        return this.suitId;
    }

    public void setAppVersion(int i) {
        this.appVersion = i;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSuitId(long j) {
        this.suitId = j;
    }
}
