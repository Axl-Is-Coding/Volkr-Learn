package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignRedPoint {
    private int betUpdateResult;
    private int integralReward;
    private int taskFinished;

    public int getBetUpdateResult() {
        return this.betUpdateResult;
    }

    public int getIntegralReward() {
        return this.integralReward;
    }

    public int getRedPointResult() {
        return this.taskFinished + this.integralReward + this.betUpdateResult;
    }

    public int getTaskFinished() {
        return this.taskFinished;
    }

    public void setBetUpdateResult(int i) {
        this.betUpdateResult = i;
    }

    public void setIntegralReward(int i) {
        this.integralReward = i;
    }

    public void setTaskFinished(int i) {
        this.taskFinished = i;
    }
}
