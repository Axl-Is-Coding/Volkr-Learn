package com.sandboxol.halloween.entity;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class HalloweenReward {
    private int candy;
    private int exchange;
    private List<String> resourceIdList;
    private String rewardDesc;
    private String rewardIcon;
    private long rewardId;
    private String rewardName;
    private String rewardType;
    private List<Integer> typeIdList;

    public int getCandy() {
        return this.candy;
    }

    public int getExchange() {
        return this.exchange;
    }

    public List<String> getResourceIdList() {
        return this.resourceIdList;
    }

    public String getRewardDesc() {
        return this.rewardDesc;
    }

    public String getRewardIcon() {
        return this.rewardIcon;
    }

    public long getRewardId() {
        return this.rewardId;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public String getRewardType() {
        return this.rewardType;
    }

    public List<Integer> getTypeIdList() {
        return this.typeIdList;
    }

    public void setCandy(int i) {
        this.candy = i;
    }

    public void setExchange(int i) {
        this.exchange = i;
    }

    public void setResourceIdList(List<String> list) {
        this.resourceIdList = list;
    }

    public void setRewardDesc(String str) {
        this.rewardDesc = str;
    }

    public void setRewardIcon(String str) {
        this.rewardIcon = str;
    }

    public void setRewardId(long j) {
        this.rewardId = j;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public void setRewardType(String str) {
        this.rewardType = str;
    }

    public void setTypeIdList(List<Integer> list) {
        this.typeIdList = list;
    }
}
