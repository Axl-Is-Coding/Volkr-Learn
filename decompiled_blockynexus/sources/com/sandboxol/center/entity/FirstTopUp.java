package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FirstTopUp {
    private List<FirstTopUpList> rewardList;
    private int status;

    public List<FirstTopUpList> getRewardList() {
        return this.rewardList;
    }

    public int getStatus() {
        return this.status;
    }

    public void setRewardList(List<FirstTopUpList> list) {
        this.rewardList = list;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
