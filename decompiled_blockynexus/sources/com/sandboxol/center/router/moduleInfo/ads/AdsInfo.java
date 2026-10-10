package com.sandboxol.center.router.moduleInfo.ads;

/* JADX INFO: loaded from: classes3.dex */
public class AdsInfo {
    private String gameId;
    private int gameIntType;
    private String gameParams;
    private int interstitialCount = 0;
    private boolean isCompleteReward = false;
    private long nextQty;
    private int nowInterstitialType;
    private int nowType;
    private long signAdsQty;

    public String getGameId() {
        return this.gameId;
    }

    public int getGameIntType() {
        return this.gameIntType;
    }

    public String getGameParams() {
        return this.gameParams;
    }

    public int getInterstitialCount() {
        return this.interstitialCount;
    }

    public long getNextQty() {
        return this.nextQty;
    }

    public int getNowInterstitialType() {
        return this.nowInterstitialType;
    }

    public int getNowType() {
        return this.nowType;
    }

    public long getSignAdsQty() {
        return this.signAdsQty;
    }

    public boolean isCompleteReward() {
        return this.isCompleteReward;
    }

    public void setCompleteReward(boolean z) {
        this.isCompleteReward = z;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setGameIntType(int i) {
        this.gameIntType = i;
    }

    public void setGameParams(String str) {
        this.gameParams = str;
    }

    public void setInterstitialCount(int i) {
        this.interstitialCount = i;
    }

    public void setNextQty(long j) {
        this.nextQty = j;
    }

    public void setNowInterstitialType(int i) {
        this.nowInterstitialType = i;
    }

    public void setNowType(int i) {
        this.nowType = i;
    }

    public void setSignAdsQty(long j) {
        this.signAdsQty = j;
    }
}
