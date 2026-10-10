package com.sandboxol.greendao.entity;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MiniGameToken {
    private String country;
    private String dispUrl;
    private String downloadUrl;
    private String mapName;
    private int region;
    private Map<Long, String> requestId;
    private String signature;
    private long timestamp;
    private String token;

    public String getCountry() {
        return this.country;
    }

    public String getDispUrl() {
        return this.dispUrl;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getMapName() {
        return this.mapName;
    }

    public int getRegion() {
        return this.region;
    }

    public Map<Long, String> getRequestId() {
        return this.requestId;
    }

    public String getSignature() {
        return this.signature;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getToken() {
        return this.token;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setMapName(String str) {
        this.mapName = str;
    }
}
