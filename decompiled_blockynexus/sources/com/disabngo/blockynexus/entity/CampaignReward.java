package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignReward {
    private List<CampaignRewardList> decorationList;
    private int goldReward;
    private int integralNeed;
    private int status;

    public List<CampaignRewardList> getDecorationList() {
        return this.decorationList;
    }

    public int getGoldReward() {
        return this.goldReward;
    }

    public int getIntegralNeed() {
        return this.integralNeed;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDecorationList(List<CampaignRewardList> list) {
        this.decorationList = list;
    }

    public void setGoldReward(int i) {
        this.goldReward = i;
    }

    public void setIntegralNeed(int i) {
        this.integralNeed = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
