package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapRewardDetails {
    private String cardDesc;
    private String cardName;
    private String cardPic;
    private int cardValue;
    private List<ScrapInfo> scrapResponses;

    public String getCardDesc() {
        return this.cardDesc;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getCardPic() {
        return this.cardPic;
    }

    public int getCardValue() {
        return this.cardValue;
    }

    public List<ScrapInfo> getScrapResponses() {
        return this.scrapResponses;
    }

    public void setCardDesc(String str) {
        this.cardDesc = str;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setCardPic(String str) {
        this.cardPic = str;
    }

    public void setCardValue(int i) {
        this.cardValue = i;
    }

    public void setScrapResponses(List<ScrapInfo> list) {
        this.scrapResponses = list;
    }
}
