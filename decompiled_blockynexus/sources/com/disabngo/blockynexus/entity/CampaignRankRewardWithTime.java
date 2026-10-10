package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignRankRewardWithTime {
    private List<CampaignRankReward> rewardList;
    private long timeLeft;

    public List<CampaignRankReward> getRewardList() {
        return this.rewardList;
    }

    public long getTimeLeft() {
        return this.timeLeft;
    }

    public void setRewardList(List<CampaignRankReward> list) {
        this.rewardList = list;
    }

    public void setTimeLeft(long j) {
        this.timeLeft = j;
    }
}
