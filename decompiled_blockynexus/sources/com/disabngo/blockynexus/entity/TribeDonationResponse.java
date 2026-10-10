package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class TribeDonationResponse {
    private int experienceGot;
    private int totalExperience;
    private int totalTribeCurrency;
    private int tribeCurrencyGot;
    private long userId;

    public int getExperienceGot() {
        return this.experienceGot;
    }

    public int getTotalExperience() {
        return this.totalExperience;
    }

    public int getTotalTribeCurrency() {
        return this.totalTribeCurrency;
    }

    public int getTribeCurrencyGot() {
        return this.tribeCurrencyGot;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setExperienceGot(int i) {
        this.experienceGot = i;
    }

    public void setTotalExperience(int i) {
        this.totalExperience = i;
    }

    public void setTotalTribeCurrency(int i) {
        this.totalTribeCurrency = i;
    }

    public void setTribeCurrencyGot(int i) {
        this.tribeCurrencyGot = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
