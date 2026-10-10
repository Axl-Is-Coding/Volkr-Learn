package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignGameRate {
    private String id;
    private String name;
    private float rate;

    public CampaignGameRate(String str, String str2, float f2) {
        this.id = str;
        this.name = str2;
        this.rate = f2;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getRate() {
        return this.rate;
    }

    public String getXRate() {
        return "x" + this.rate;
    }

    public boolean isShow() {
        return this.rate < 1.0f;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRate(int i) {
        this.rate = i;
    }
}
