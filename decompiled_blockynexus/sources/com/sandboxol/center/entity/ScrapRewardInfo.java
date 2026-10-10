package com.sandboxol.center.entity;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapRewardInfo {
    private String cardId;
    private String cardName;
    private String cardPic;
    private String cardProgress;
    private int cardQuality;
    private int cardRewardType = 1;
    private int rewardExpires;
    private int status;

    public String getCardId() {
        return this.cardId;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getCardPic() {
        return this.cardPic;
    }

    public String getCardProgress() {
        return this.cardProgress;
    }

    public int getCardQuality() {
        return this.cardQuality;
    }

    public int getCardRewardType() {
        return this.cardRewardType;
    }

    public int getRewardExpires() {
        return this.rewardExpires;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setCardPic(String str) {
        this.cardPic = str;
    }

    public void setCardProgress(String str) {
        this.cardProgress = str;
    }

    public void setCardQuality(int i) {
        this.cardQuality = i;
    }

    public void setCardRewardType(int i) {
        this.cardRewardType = i;
    }

    public void setRewardExpires(int i) {
        this.rewardExpires = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
