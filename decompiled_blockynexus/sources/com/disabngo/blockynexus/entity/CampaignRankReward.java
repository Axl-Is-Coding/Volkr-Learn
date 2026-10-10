package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CampaignRankReward {
    private boolean isFirst;
    private boolean isLast;
    private String rank;
    private List<String> rewardInfo;
    private List<String> rewardPic;

    public CampaignRankReward(boolean z, boolean z2) {
        this.isFirst = false;
        this.isLast = false;
        this.isFirst = z;
        this.isLast = z2;
    }

    public String getRank() {
        return this.rank;
    }

    public List<String> getRewardInfo() {
        return this.rewardInfo;
    }

    public List<String> getRewardPic() {
        return this.rewardPic;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setLast(boolean z) {
        this.isLast = z;
    }

    public void setRank(String str) {
        this.rank = str;
    }

    public void setRewardInfo(List<String> list) {
        this.rewardInfo = list;
    }

    public void setRewardPic(List<String> list) {
        this.rewardPic = list;
    }

    public CampaignRankReward(String str, List<String> list, List<String> list2) {
        this.isFirst = false;
        this.isLast = false;
        this.rank = str;
        this.rewardInfo = list;
        this.rewardPic = list2;
    }
}
