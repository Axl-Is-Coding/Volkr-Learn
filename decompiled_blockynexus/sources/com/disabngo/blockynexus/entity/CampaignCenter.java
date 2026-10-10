package com.disabngo.blockynexus.entity;

import androidx.databinding.ObservableField;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignCenter {
    private static CampaignCenter instance;
    public ObservableField<Integer> integral = new ObservableField<>(0);
    public ObservableField<String> rank = new ObservableField<>("-");
    public ObservableField<Integer> taskFinished = new ObservableField<>(0);
    public ObservableField<Integer> integralReward = new ObservableField<>(0);
    public ObservableField<Integer> betUpdateResult = new ObservableField<>(0);
    public ObservableField<Integer> redPointTotal = new ObservableField<>(0);

    public static CampaignCenter newInstance() {
        if (instance == null) {
            instance = new CampaignCenter();
        }
        return instance;
    }

    public void addBetUpdateResult() {
        ObservableField<Integer> observableField = this.betUpdateResult;
        observableField.set(Integer.valueOf(observableField.get().intValue() + 1));
        this.redPointTotal.set(Integer.valueOf(this.integralReward.get().intValue() + this.betUpdateResult.get().intValue() + this.taskFinished.get().intValue()));
    }

    public void addIntegralReward() {
        ObservableField<Integer> observableField = this.integralReward;
        observableField.set(Integer.valueOf(observableField.get().intValue() + 1));
        this.redPointTotal.set(Integer.valueOf(this.integralReward.get().intValue() + this.betUpdateResult.get().intValue() + this.taskFinished.get().intValue()));
    }

    public void addTaskFinished() {
        ObservableField<Integer> observableField = this.taskFinished;
        observableField.set(Integer.valueOf(observableField.get().intValue() + 1));
        this.redPointTotal.set(Integer.valueOf(this.integralReward.get().intValue() + this.betUpdateResult.get().intValue() + this.taskFinished.get().intValue()));
    }

    public void logout() {
        instance.integral.set(0);
        instance.rank.set("-");
        this.taskFinished.set(0);
        this.integralReward.set(0);
        this.betUpdateResult.set(0);
        this.redPointTotal.set(0);
    }

    public void setRedPointInfo(CampaignRedPoint campaignRedPoint) {
        this.taskFinished.set(Integer.valueOf(campaignRedPoint.getTaskFinished()));
        this.integralReward.set(Integer.valueOf(campaignRedPoint.getIntegralReward()));
        this.betUpdateResult.set(Integer.valueOf(campaignRedPoint.getBetUpdateResult()));
        this.redPointTotal.set(Integer.valueOf(campaignRedPoint.getRedPointResult()));
    }

    public void subtractBetUpdateResult() {
        this.betUpdateResult.set(0);
        this.redPointTotal.set(Integer.valueOf(this.taskFinished.get().intValue() + this.integralReward.get().intValue()));
    }

    public void subtractIntegralReward() {
        this.integralReward.set(0);
        this.redPointTotal.set(Integer.valueOf(this.taskFinished.get().intValue() + this.betUpdateResult.get().intValue()));
    }

    public void subtractTaskFinished(int i) {
        if (this.taskFinished.get().intValue() > 0) {
            this.taskFinished.set(Integer.valueOf(r3.get().intValue() - 1));
        }
        this.redPointTotal.set(Integer.valueOf(this.integralReward.get().intValue() + this.betUpdateResult.get().intValue() + this.taskFinished.get().intValue()));
    }
}
