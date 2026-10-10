package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupParam {
    private int cost;
    private int currency;
    private List<Long> memberIds;
    private long userId;

    public int getCost() {
        return this.cost;
    }

    public int getCurrency() {
        return this.currency;
    }

    public List<Long> getMemberIds() {
        return this.memberIds;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setCost(int i) {
        this.cost = i;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public void setMemberIds(List<Long> list) {
        this.memberIds = list;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
