package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityTaskActionReward {
    private int decorationId;
    private int isShowDesc;
    private int level;
    private int quantity;
    private String rewardDesc;
    private String rewardName;
    private String rewardPic;
    private String rewardType;

    public int getDecorationId() {
        return this.decorationId;
    }

    public int getIsShowDesc() {
        return this.isShowDesc;
    }

    public int getLevel() {
        return this.level;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getRewardDesc() {
        return this.rewardDesc;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public String getRewardPic() {
        return this.rewardPic;
    }

    public String getRewardType() {
        return this.rewardType;
    }

    public boolean isShowRewardName() {
        return "decoration".equals(this.rewardType);
    }

    public void setDecorationId(int i) {
        this.decorationId = i;
    }

    public void setIsShowDesc(int i) {
        this.isShowDesc = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setRewardDesc(String str) {
        this.rewardDesc = str;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public void setRewardPic(String str) {
        this.rewardPic = str;
    }

    public void setRewardType(String str) {
        this.rewardType = str;
    }
}
