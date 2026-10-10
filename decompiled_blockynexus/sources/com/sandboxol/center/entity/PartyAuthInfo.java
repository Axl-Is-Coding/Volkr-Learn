package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class PartyAuthInfo {
    private String country;
    private String dispUrl;
    private String engineType;
    private String partyQuerierService;
    private String partyService;
    private int region;
    private String signature;
    private long timestamp;
    private String token;

    public String getCountry() {
        return this.country;
    }

    public String getDispUrl() {
        return this.dispUrl;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public String getPartyQuerierService() {
        return this.partyQuerierService;
    }

    public String getPartyService() {
        return this.partyService;
    }

    public int getRegion() {
        return this.region;
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

    public void setDispUrl(String str) {
        this.dispUrl = str;
    }

    public void setEngineType(String str) {
        this.engineType = str;
    }

    public void setPartyQuerierService(String str) {
        this.partyQuerierService = str;
    }

    public void setPartyService(String str) {
        this.partyService = str;
    }

    public void setRegion(int i) {
        this.region = i;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
