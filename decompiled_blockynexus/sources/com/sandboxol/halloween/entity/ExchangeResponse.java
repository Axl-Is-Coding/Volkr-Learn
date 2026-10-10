package com.sandboxol.halloween.entity;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ExchangeResponse {
    private int candy;
    private List<RewardDetailInfo> rewardList;

    public int getCandy() {
        return this.candy;
    }

    public List<RewardDetailInfo> getRewardList() {
        return this.rewardList;
    }

    public void setCandy(int i) {
        this.candy = i;
    }

    public void setRewardList(List<RewardDetailInfo> list) {
        this.rewardList = list;
    }
}
