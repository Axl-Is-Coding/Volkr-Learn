package com.sandboxol.greendao.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ChristmasAllRewardInfo {
    private ChristmasRewardInfo freeReward;
    private int level;
    private ChristmasRewardInfo payReward;

    public ChristmasAllRewardInfo(int i, ChristmasRewardInfo christmasRewardInfo, ChristmasRewardInfo christmasRewardInfo2) {
        this.level = i;
        this.freeReward = christmasRewardInfo;
        this.payReward = christmasRewardInfo2;
    }

    public ChristmasRewardInfo getFreeReward() {
        return this.freeReward;
    }

    public int getLevel() {
        return this.level;
    }

    public ChristmasRewardInfo getPayReward() {
        return this.payReward;
    }

    public String getStringLevel() {
        return "";
    }

    public void setFreeReward(ChristmasRewardInfo christmasRewardInfo) {
        this.freeReward = christmasRewardInfo;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setPayReward(ChristmasRewardInfo christmasRewardInfo) {
        this.payReward = christmasRewardInfo;
    }
}
